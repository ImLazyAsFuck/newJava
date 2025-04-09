package bussiness.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB{
    private static final String URL = "jdbc:mysql://localhost:3306/Banking_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "a@1234";

    public static Connection openConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            System.out.println("Error opening connection cause: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Unknown error while connecting to SQL " + e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement callSt){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        if(callSt != null){
            try{
                callSt.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
