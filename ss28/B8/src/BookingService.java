import java.sql.*;
import java.time.LocalDateTime;

public class BookingService {

    public void bookRoom(int customerId, int roomId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            ps = conn.prepareStatement("SELECT * FROM b8customers WHERE customer_id = ?");
            ps.setInt(1, customerId);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Customer does not exist");
            }
            rs.close();
            ps.close();

            ps = conn.prepareStatement("SELECT availability FROM b8rooms WHERE room_id = ? FOR UPDATE");
            ps.setInt(1, roomId);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Room does not exist");
            }
            String availability = rs.getString("availability");
            rs.close();
            ps.close();

            if (!"available".equalsIgnoreCase(availability)) {
                throw new SQLException("Room is not available");
            }

            ps = conn.prepareStatement("UPDATE b8rooms SET availability = 'unavailable' WHERE room_id = ?");
            ps.setInt(1, roomId);
            ps.executeUpdate();
            ps.close();

            ps = conn.prepareStatement(
                    "INSERT INTO b8bookings (customer_id, room_id, booking_date, status) VALUES (?, ?, ?, ?)");
            ps.setInt(1, customerId);
            ps.setInt(2, roomId);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(4, "confirmed");
            ps.executeUpdate();

            conn.commit();
            System.out.println("Booking successful");

        } catch (Exception e) {
            System.err.println("Booking failed: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.err.println("Rollback failed: " + ex.getMessage());
                }
            }

            try {
                Connection logConn = DBUtil.getConnection();
                PreparedStatement logPs = logConn.prepareStatement(
                        "INSERT INTO b8failed_bookings (customer_id, room_id, reason, booking_date) VALUES (?, ?, ?, ?)");
                logPs.setInt(1, customerId);
                logPs.setInt(2, roomId);
                logPs.setString(3, e.getMessage());
                logPs.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
                logPs.executeUpdate();
                logPs.close();
                logConn.close();
            } catch (SQLException ex) {
                System.err.println("Failed to log error: " + ex.getMessage());
            }

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Failed to close resources: " + e.getMessage());
            }
        }
    }
}
