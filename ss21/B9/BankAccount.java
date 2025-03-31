package B9;

public class BankAccount{
    private String accountId;
    private double balance;

    public BankAccount() {}

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền gửi phải lớn hơn 0.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Số dư không đủ.");
        }
        balance -= amount;
    }

    public void transfer(BankAccount toAccount, double amount) {
        if (toAccount == null) {
            throw new IllegalArgumentException("Tài khoản nhận không tồn tại.");
        }
        this.withdraw(amount);
        toAccount.deposit(amount);
    }
}
