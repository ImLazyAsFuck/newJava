import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ss28";
        String user = "root";
        String password = "a@1234";

        int fromAccountId = 1;
        int toAccountId = 2;
        double amount = 100.0;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            try {
                if (!updateBalance(conn, fromAccountId, -amount)) {
                    throw new SQLException("Not enough balance");
                }
                if (!updateBalance(conn, toAccountId, amount)) {
                    throw new SQLException("Error while update balance ");
                }
                System.out.println("Transfer successfully");
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("Failed to tranfer. Cause: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean updateBalance(Connection conn, int accountId, double amount) throws SQLException {
        if (amount < 0) {
            String checkSql = "SELECT balance FROM b3 WHERE id = ?";
            PreparedStatement checkStmt = null;
            try {
                checkStmt = conn.prepareStatement(checkSql);
                checkStmt.setInt(1, accountId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    double currentBalance = rs.getDouble("balance");
                    if (currentBalance + amount < 0) return false;
                } else {
                    return false;
                }
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

        String updateSql = "UPDATE b3 SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(updateSql)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            return stmt.executeUpdate() >= 1;
        }
    }
}
