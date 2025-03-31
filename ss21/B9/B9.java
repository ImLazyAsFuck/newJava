package B9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B9{
    public static void main(String[] args) {
        Map<String, BankAccount> accounts = new HashMap<>();
        accounts.put("123", new BankAccount("123", 5000));
        accounts.put("456", new BankAccount("456", 3000));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Chọn chức năng: 1. Gửi tiền 2. Rút tiền 3. Chuyển tiền 4. Thoát");
            int choice = scanner.nextInt();
            if (choice == 4) break;

            System.out.print("Nhập số tài khoản: ");
            String accId = scanner.nextLine();
            BankAccount account = accounts.get(accId);
            if (account == null) {
                System.out.println("Tài khoản không tồn tại.");
                continue;
            }

            try {
                if (choice == 1) {
                    System.out.print("Nhập số tiền gửi: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("Số dư hiện tại: " + account.getBalance());
                } else if (choice == 2) {
                    System.out.print("Nhập số tiền rút: ");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                    System.out.println("Số dư hiện tại: " + account.getBalance());
                } else if (choice == 3) {
                    System.out.print("Nhập số tài khoản nhận: ");
                    String toAccId = scanner.next();
                    BankAccount toAccount = accounts.get(toAccId);
                    System.out.print("Nhập số tiền chuyển: ");
                    double amount = scanner.nextDouble();
                    account.transfer(toAccount, amount);
                    System.out.println("Chuyển tiền thành công.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
