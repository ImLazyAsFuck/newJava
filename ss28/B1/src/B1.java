import java.sql.*;

public class B1{
    public static void main(String[] args){
        final String url = "jdbc:mysql://localhost:3306/Ss28";
        final String username = "root";
        final String password = "a@1234";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully!");
            System.out.println("First auto-commit: " + conn.getAutoCommit());
            conn.setAutoCommit(false);
            System.out.println("Turned off auto-commit: " + conn.getAutoCommit());

            PreparedStatement pstmt = conn.prepareStatement("insert into B1(name,age) values(?,?)");
            pstmt.setString(1, "Nguyễn Văn A");
            pstmt.setInt(2, 20);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("rows inserted: " + rowsInserted);

            conn.commit();
            System.out.println("Committed");

            pstmt = conn.prepareStatement("select * from b1 where id = ?");
            pstmt.setInt(1, 1);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getInt("id") + ", " +
                        rs.getString("name") + ", " +
                        rs.getInt("age"));
            } else {
                System.out.println("Data not found");
            }

        } catch (SQLException e) {
            e.fillInStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Rolled back transaction cause unknown exception");
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.fillInStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.close();
                System.out.println("Closed connection");
            } catch (SQLException e) {
                e.fillInStackTrace();
            }
        }
    }
}
