import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/ss28";
            String user = "root";
            String password = "a@1234";

            conn = DriverManager.getConnection(url, user, password);
            OrderService service = new OrderService(conn);

            Orders order = new Orders("Tokisaki Kurumi", LocalDate.now());
            order.addDetail(new OrderDetail("Laptop", 1));
            order.addDetail(new OrderDetail("Iphone", 3));

            service.createOrder(order);

        } catch (SQLException e) {
            System.err.println("Connection or processing error: " + e.getMessage());
        } finally {
            if (conn != null) try { conn.close(); } catch (Exception e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
