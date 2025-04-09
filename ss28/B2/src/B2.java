import java.sql.*;

public class B2{
    public static void main(String[] args) {
        final String jdbcUrl = "jdbc:mysql://localhost:3306/ss28";
        final String username = "root";
        final String password = "a@1234";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            conn.setAutoCommit(false);
            try{
                PreparedStatement insert1 = conn.prepareStatement("INSERT INTO b2(id, name) VALUES(1, 'Alice')");
                PreparedStatement insert2 = conn.prepareStatement("INSERT INTO b2(id, name) VALUES(1, 'Bob')");
                insert1.executeUpdate();
                insert2.executeUpdate();
                conn.commit();
                System.out.println("Both rows inserted: .");
            } catch (SQLException e) {
                System.out.println("Error something went wrong roll back");
                conn.rollback();
                e.fillInStackTrace();
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM b2 WHERE id = 1");
            if (!rs.next()) {
                System.out.println("No rows inserted roll back.");
            } else {
                System.out.println("Error: data already exists roll back.");
            }

        } catch (SQLException e) {
            e.fillInStackTrace();
            System.out.println("Error SQL: " + e.getMessage());
        }
    }
}
