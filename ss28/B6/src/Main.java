import java.sql.*;
import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/ss28";
        String username = "root";
        String password = "a@1234";

        String departmentName = "Phòng Kỹ Thuật";
        List<String> employeeNames = Arrays.asList("Hana", "Yuuto", "Kazuki");

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            conn.setAutoCommit(false);

            try {
                String insertDept = "INSERT INTO b6departments (name) VALUES (?)";
                PreparedStatement deptStmt = conn.prepareStatement(insertDept, Statement.RETURN_GENERATED_KEYS);
                deptStmt.setString(1, departmentName);
                deptStmt.executeUpdate();

                ResultSet rs = deptStmt.getGeneratedKeys();
                int departmentId = -1;
                if (rs.next()) {
                    departmentId = rs.getInt(1);
                } else {
                    throw new SQLException("Failed to retrieve new department ID.");
                }

                String insertEmp = "INSERT INTO b6employees (name, department_id) VALUES (?, ?)";
                PreparedStatement empStmt = conn.prepareStatement(insertEmp);

                for (String empName : employeeNames) {
                    empStmt.setString(1, empName);
                    empStmt.setInt(2, departmentId);
                    empStmt.executeUpdate();
                }

                conn.commit();
                System.out.println("Transaction completed. Department and employees have been added.");

            } catch (SQLException ex) {
                conn.rollback();
                System.err.println("An error occurred, rolling back transaction. Error: " + ex.getMessage());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
