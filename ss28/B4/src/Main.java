import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ss28";
        String user = "root";
        String password = "a@1234";

        int fromId = 1;
        int toId = 2;
        double amount = 500.0;

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement withdrawStmt = null;
        PreparedStatement depositStmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            String bankA = null;
            double balanceA = 0;
            stmt = conn.prepareStatement("SELECT bank_name, balance FROM b4 WHERE account_id = ?");
            stmt.setInt(1, fromId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                bankA = rs.getString("bank_name");
                balanceA = rs.getDouble("balance");
            } else {
                throw new SQLException("Sender not exist");
            }
            rs.close();

            String bankB = null;
            stmt.setInt(1, toId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                bankB = rs.getString("bank_name");
            } else {
                throw new SQLException("Bank does not exist");
            }
            rs.close();

            if (bankA.equals(bankB)) {
                throw new SQLException("Can't transfer money from same account");
            }
            if (balanceA < amount) {
                throw new SQLException("Not enough balance");
            }

            withdrawStmt = conn.prepareStatement("UPDATE b4 SET balance = balance - ? WHERE account_id = ?");
            withdrawStmt.setDouble(1, amount);
            withdrawStmt.setInt(2, fromId);
            int r1 = withdrawStmt.executeUpdate();
            if (r1 != 1) throw new SQLException("Error while transfer money");

            depositStmt = conn.prepareStatement("UPDATE b4 SET balance = balance + ? WHERE account_id = ?");
            depositStmt.setDouble(1, amount);
            depositStmt.setInt(2, toId);
            int r2 = depositStmt.executeUpdate();
            if (r2 != 1) throw new SQLException("Error while deposit");

            conn.commit();
            System.out.println("Transfer successfully");

        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
                System.err.println("Rolled back connection");
            } catch (SQLException ex) {
                System.err.println("Rolled failed: " + ex.getMessage());
            }
        }
    }
}
