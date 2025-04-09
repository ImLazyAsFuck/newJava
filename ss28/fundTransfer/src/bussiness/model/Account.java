package bussiness.model;

public class Account{
    private int accId;
    private String accName;
    private double balance;
    private AccountStatus accStatus;


    public Account(int accId, String accName, double balance, AccountStatus accStatus){
        this.accId = accId;
        this.accName = accName;
        this.balance = balance;
        this.accStatus = accStatus;
    }

    public Account(){
    }

    public int getAccId(){
        return accId;
    }

    public void setAccId(int accId){
        this.accId = accId;
    }

    public String getAccName(){
        return accName;
    }

    public void setAccName(String accName){
        this.accName = accName;
    }

    public AccountStatus getAccStatus(){
        return accStatus;
    }

    public void setAccStatus(AccountStatus accStatus){
        this.accStatus = accStatus;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    @Override
    public String toString(){
        return "Id: " + accId + ", Name: " + accName + ", Balance: " + balance + ", AccountStatus: " + accStatus;
    }
}
