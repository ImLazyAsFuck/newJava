package B9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

public class B9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> phones = new ArrayList<>();
        int n = 0;

        try {
            System.out.print("Enter Amount of Phone Numbers: ");
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Số lượng phải là số nguyên.");
            return;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Phone Number " + i + ": ");
            phones.add(sc.nextLine().trim());
        }

        for (String phone : phones) {
            try {
                validatePhoneNumber(phone);
                System.out.println("Hợp lệ: " + phone);
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: " + phone + " chứa ký tự không hợp lệ.");
            } catch (InvalidPhoneNumberException e) {
                System.err.println("Lỗi: " + phone + " có độ dài không hợp lệ.");
            }
        }
    }

    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberException {
        if (!phone.matches("\\d+")) {
            throw new NumberFormatException();
        }
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberException("Số điện thoại phải có đúng 10 chữ số.");
        }
    }
}
