import java.sql.*;

public class AuctionService {

    public void placeBid(int userId, int auctionId, double bidAmount) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);

            ps = conn.prepareStatement("SELECT balance FROM b9users WHERE user_id = ?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (!rs.next()) throw new SQLException("User not found");
            double balance = rs.getDouble("balance");
            rs.close();
            ps.close();

            if (balance < bidAmount) throw new SQLException("Insufficient balance");

            ps = conn.prepareStatement("SELECT highest_bid FROM b9auctions WHERE auction_id = ? FOR UPDATE");
            ps.setInt(1, auctionId);
            rs = ps.executeQuery();
            if (!rs.next()) throw new SQLException("Auction not found");
            double currentHighest = rs.getDouble("highest_bid");
            rs.close();
            ps.close();

            if (bidAmount <= currentHighest) throw new SQLException("Bid too low");

            ps = conn.prepareStatement("UPDATE b9auctions SET highest_bid = ? WHERE auction_id = ?");
            ps.setDouble(1, bidAmount);
            ps.setInt(2, auctionId);
            ps.executeUpdate();
            ps.close();

            ps = conn.prepareStatement("INSERT INTO b9bids (auction_id, user_id, bid_amount) VALUES (?, ?, ?)");
            ps.setInt(1, auctionId);
            ps.setInt(2, userId);
            ps.setDouble(3, bidAmount);
            ps.executeUpdate();

            conn.commit();
            System.out.println("Bid placed successfully");

        } catch (Exception e) {
            System.err.println("Bid failed: " + e.getMessage());

            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                System.err.println("Rollback failed: " + ex.getMessage());
            }

            try {
                Connection logConn = DBUtil.getConnection();
                PreparedStatement logPs = logConn.prepareStatement(
                        "INSERT INTO b9failed_bids (user_id, auction_id, bid_amount, reason) VALUES (?, ?, ?, ?)");
                logPs.setInt(1, userId);
                logPs.setInt(2, auctionId);
                logPs.setDouble(3, bidAmount);
                logPs.setString(4, e.getMessage());
                logPs.executeUpdate();
                logPs.close();
                logConn.close();
            } catch (SQLException ex) {
                System.err.println("Failed to log failed bid: " + ex.getMessage());
            }

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Closing resources failed: " + e.getMessage());
            }
        }
    }
}
