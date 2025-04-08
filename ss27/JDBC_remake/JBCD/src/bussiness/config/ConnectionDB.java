package src.bussiness.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/StudentManagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "a@1234";

    public static Connection openConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            System.err.println("Kết nối thất bại: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void closeConnection(Connection con, CallableStatement cs) {
        try {
            if (cs != null) {
                cs.close();
                System.out.println("Đã đóng CallableStatement!");
            }
        } catch (SQLException e) {
            System.err.println("⚠Lỗi khi đóng CallableStatement: " + e.getMessage());
        }

        try {
            if (con != null) {
                con.close();
                System.out.println("Đã đóng Connection!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi đóng Connection: " + e.getMessage());
        }
    }
}
