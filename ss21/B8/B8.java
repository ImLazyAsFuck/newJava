import B8.InvalidPhoneNumberExeption;

import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập các số điện thoại, cách nhau bằng dấu phẩy:");

    try {
        String input = scanner.nextLine();
        String[] phoneNumbers = input.split(",");

        for (String phoneNumber : phoneNumbers) {
            phoneNumber = phoneNumber.trim();
            try {
                validatePhoneNumber(phoneNumber);
                System.out.println(phoneNumber + " là số hợp lệ.");
            } catch (InvalidPhoneNumberExeption e) {
                System.out.println(phoneNumber + " là số không hợp lệ: " + e.getMessage());
            }
        }
    } catch (Exception e) {
        System.out.println("Đã xảy ra lỗi: " + e.getMessage());
    } finally {
        scanner.close();
    }
}

public static void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberExeption {
    if (!phoneNumber.matches("\\d{10}")) {
        throw new InvalidPhoneNumberExeption("Số điện thoại phải có đúng 10 chữ số.");
    }
}