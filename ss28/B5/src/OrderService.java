import java.sql.*;

public class OrderService {
    private final Connection connection;

    public OrderService(Connection connection) {
        this.connection = connection;
    }

    public void createOrder(Orders order) throws SQLException {
        PreparedStatement orderStmt = null;
        PreparedStatement detailStmt = null;
        ResultSet keys = null;

        try {
            connection.setAutoCommit(false);

            String insertOrderSQL = "INSERT INTO b5Orders (customer_name, order_date) VALUES (?, ?)";
            orderStmt = connection.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS);
            orderStmt.setString(1, order.getCustomerName());
            orderStmt.setDate(2, Date.valueOf(order.getOrderDate()));
            orderStmt.executeUpdate();

            keys = orderStmt.getGeneratedKeys();
            if (keys.next()) {
                int orderId = keys.getInt(1);
                order.setOrderId(orderId);

                String insertDetailSQL = "INSERT INTO b5OrderDetails (order_id, product_name, quantity) VALUES (?, ?, ?)";
                detailStmt = connection.prepareStatement(insertDetailSQL);

                for (OrderDetail detail : order.getDetails()) {
                    if (detail.getQuantity() < 0) {
                        throw new IllegalArgumentException("Quantity must not be negative!");
                    }

                    detailStmt.setInt(1, orderId);
                    detailStmt.setString(2, detail.getProductName());
                    detailStmt.setInt(3, detail.getQuantity());
                    detailStmt.executeUpdate();
                }

                connection.commit();
                System.out.println("Order and details have been saved successfully!");
            } else {
                throw new SQLException("Failed to retrieve the generated order ID!");
            }

        } catch (Exception e) {
            connection.rollback();
            System.err.println("Error: " + e.getMessage());
            System.out.println("Transaction has been rolled back.");
        }
    }
}
