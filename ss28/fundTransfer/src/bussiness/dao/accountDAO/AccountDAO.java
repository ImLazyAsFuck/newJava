package bussiness.dao.accountDAO;

import bussiness.dao.AppDAO;

public interface AccountDAO extends AppDAO{
    int fundTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
}
