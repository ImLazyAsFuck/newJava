import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ss28";
        String user = "root";
        String password = "a@1234";

        Connection con = null;
        PreparedStatement insertOrderStmt = null;
        PreparedStatement insertDetailStmt = null;
        ResultSet generatedKeys = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
            String insertOrderSQL = "INSERT INTO Orders (customer_name) VALUES (?)";
            insertOrderStmt = con.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS);
            insertOrderStmt.setString(1, "Hoang");
            insertOrderStmt.executeUpdate();
            generatedKeys = insertOrderStmt.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new SQLException("Can't get ID from the generated keys");
            }
            int orderId = generatedKeys.getInt(1);
            String insertDetailSQL = "INSERT INTO OrderDetails (order_id, product_name, quantity) VALUES (?, ?, ?)";
            insertDetailStmt = con.prepareStatement(insertDetailSQL);
            List<OrderDetail> details = Arrays.asList(
                    new OrderDetail("Táo", 10),
                    new OrderDetail("Cam", 5),
                    new OrderDetail("Chuối", -3)
            );

            for (OrderDetail detail : details) {
                if (detail.quantity < 0) {
                    throw new SQLException("Amount can't be negative");
                }

                insertDetailStmt.setInt(1, orderId);
                insertDetailStmt.setString(2, detail.productName);
                insertDetailStmt.setInt(3, detail.quantity);
                insertDetailStmt.executeUpdate();
            }
            con.commit();
            System.out.println("Transfer successful!");

        } catch (SQLException e) {
            System.err.println("Catch Error. Roll back!");
            e.printStackTrace();
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (insertOrderStmt != null) insertOrderStmt.close();
                if (insertDetailStmt != null) insertDetailStmt.close();
                if (con != null) con.setAutoCommit(true);
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    static class OrderDetail {
        String productName;
        int quantity;
        public OrderDetail(String productName, int quantity) {
            this.productName = productName;
            this.quantity = quantity;
        }
    }
}
