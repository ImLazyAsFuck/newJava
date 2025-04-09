package bussiness.dao.accountDAO;

import bussiness.config.ConnectionDB;
import bussiness.model.Account;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImp implements AccountDAO {
    @Override
    public int fundTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount){
        return 0;
    }

    @Override
    public List<Account> getAllAccount(Object o){
        List<Account> accounts = new ArrayList<Account>();
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = ConnectionDB.openConnection();
            con.setAutoCommit(false);

        }catch(SQLException e){
            System.out.println("Error connect to SQL: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Unknown error while connect to SQL: " + e.getMessage());
        }
    }

    @Override
    public boolean save(Object o){
        return false;
    }

    @Override
    public boolean delete(Object o){
        return false;
    }

    @Override
    public boolean update(Object o){
        return false;
    }
}
