package bussiness.dao.userDAO;

import bussiness.config.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImp implements UserDAO{
    @Override
    public boolean login(String username, String password){
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call login(?, ?)}");
            cs.setString(1, username);
            cs.setString(2, password);
            rs = cs.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println("\u001B[31mError while connecting to SQL\u001B[31m");
            return false;
        }catch(Exception e){
            System.out.println("\u001B[31mUnknown Error while connecting to SQL\u001B[31m");
            return false;
        }
        ConnectionDB.closeConnection(con, cs);
        return false;
    }
}
