package bussiness.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB{
    public static final String URL = AuthConfig.getUrl();
    public static final String USER_NAME = AuthConfig.getUsername();
    public static final String PASSWORD = AuthConfig.getPassword();

    public static Connection openConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("\u001B[31mError while connecting to SQL cause: " + e.getMessage() + "\u001B[31m");
        } catch (Exception e) {
            System.out.println("\u001B[31mUnknown error when connect to SQL : " + e.getMessage() + "\u001B[31m");
        }
        return conn;
    }

    public static void closeConnection(Connection con, CallableStatement cs){
        if(con != null){
            try{
                con.close();
            }catch(SQLException e){
                System.out.println("\u001B[31mCatch error while closing connection statement" + "\u001B[31m");
            }
        }
        if(cs != null){
            try{
                cs.close();
            }catch(SQLException e){
                System.out.println("\u001B[31mCatch error while closing callable statement" + e.getMessage() + "\u001B[31m");
            }
        }
    }
}
