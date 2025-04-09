import java.sql.*;

public class Main {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/ss28";
    static final String USER = "root";
    static final String PASS = "a@1234";

    public static void main(String[] args) throws Exception {
        testIsolationLevel(Connection.TRANSACTION_READ_UNCOMMITTED, "READ_UNCOMMITTED");
        testIsolationLevel(Connection.TRANSACTION_READ_COMMITTED, "READ_COMMITTED");
        testIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ, "REPEATABLE_READ");
        testIsolationLevel(Connection.TRANSACTION_SERIALIZABLE, "SERIALIZABLE");
    }

    static void testIsolationLevel(int level, String levelName) throws Exception {
        System.out.println("=== Testing Isolation Level: " + levelName + " ===");

        Connection conn1 = DriverManager.getConnection(JDBC_URL, USER, PASS);
        conn1.setAutoCommit(false);
        conn1.setTransactionIsolation(level);

        Connection conn2 = DriverManager.getConnection(JDBC_URL, USER, PASS);
        conn2.setAutoCommit(false);

        PreparedStatement insertStmt = conn2.prepareStatement(
                "INSERT INTO b7orders (customer_name, status) VALUES (?, ?)");
        insertStmt.setString(1, "TestCustomer_" + levelName);
        insertStmt.setString(2, "PENDING");
        insertStmt.executeUpdate();
        System.out.println("[Writer] Inserted order but not committed.");
        Thread.sleep(1000);
        Statement readerStmt = conn1.createStatement();
        ResultSet rs = readerStmt.executeQuery("SELECT * FROM b7orders WHERE customer_name LIKE 'TestCustomer_%'");
        System.out.println("[Reader] Reading orders...");

        boolean hasResults = false;
        while (rs.next()) {
            hasResults = true;
            System.out.println("[Reader] Order: ID=" + rs.getInt("order_id") +
                    ", Name=" + rs.getString("customer_name") +
                    ", Status=" + rs.getString("status"));
        }

        if (!hasResults) {
            System.out.println("[Reader] No uncommitted data visible.");
        }

        conn1.rollback();
        conn2.rollback();
        conn1.close();
        conn2.close();
        System.out.println("=== End of " + levelName + " ===\n");
    }
}
