package validator;


import bussiness.model.employeeModel.EmployeeStatus;
import bussiness.model.employeeModel.Gender;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EmployeeValidator{
    private final static Set<String> UNIQUE_ID = new HashSet<>();
    private final static Set<String> UNIQUE_EMAIL = new HashSet<>();
    private final static Set<String> UNIQUE_PHONE = new HashSet<>();

    public static String validateEmployeeId(Scanner input, String message, String regex){
        while(true){
            try{
                System.out.print(message);
                String id = input.nextLine().trim();
                if(id.isEmpty()){
                    throw new IllegalArgumentException("ID cannot be empty!");
                }
                if(UNIQUE_ID.contains(id)){
                    throw new IllegalArgumentException("ID already exists!");
                }
                if(!id.matches(regex)){
                    throw new IllegalArgumentException("Invalid ID! Please enter ID that start with B and 4 digits");
                }
                UNIQUE_ID.add(id);
                return id;
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
            }
        }
    }

    public static String validateEmail(Scanner input, String message, String regex){
        while(true){
            try{
                System.out.print(message);
                String email = input.nextLine().trim();
                if(email.isEmpty()){
                    throw new IllegalArgumentException("Email cannot be empty!");
                }
                if(UNIQUE_EMAIL.contains(email)){
                    throw new IllegalArgumentException("Email already exists!");
                }
                if(!email.matches(regex)){
                    throw new IllegalArgumentException("Invalid email! Email must be email@domain.com");
                }
                UNIQUE_EMAIL.add(email);
                return email;
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
            }
        }
    }

    public static int validateGetDepartment(Scanner input, String message){
        while(true){
            try{
                System.out.print(message);
                int departmentId = Integer.parseInt(input.nextLine().trim());
//                if(List)
            }catch(NumberFormatException e){
                System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
            }
        }
    }

    public static String validatePhoneNumber(Scanner input, String message, String regex){
        while(true){
            try{
                System.out.print(message);
                String phone = input.nextLine().trim();
                if(phone.isEmpty()){
                    throw new IllegalArgumentException("Phone number cannot be empty!");
                }
                if(UNIQUE_PHONE.contains(phone)){
                    throw new IllegalArgumentException("Phone number already exists!");
                }
                if(!phone.matches(regex)){
                    throw new IllegalArgumentException("Invalid phone number! Phone must start with 0 and 9 numbers");
                }
                UNIQUE_PHONE.add(phone);
                return phone;
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
            }
        }
    }

    public static Gender validateGender(Scanner input, String message){
        while(true){
            try{
                System.out.print(message);
                String gender = input.nextLine().trim();
                if(gender.isEmpty()){
                    throw new IllegalArgumentException("Gender cannot be empty!");
                }
                switch (gender.toLowerCase()){
                    case "male":
                        return Gender.MALE;
                    case "female":
                        return Gender.FEMALE;
                    case "other":
                        return Gender.OTHER;
                    default:
                        throw new IllegalArgumentException("Invalid gender. Please enter male, female, or other.");
                }
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
            }
        }
    }

    public static EmployeeStatus validateStatus(Scanner input, String message) {
        while(true){
            try{
                System.out.print(message);
                String status = input.nextLine().trim();
                if(status.isEmpty()){
                    throw new IllegalArgumentException("Status cannot be empty!");
                }
                switch (status.toLowerCase()){
                    case "active":
                        return EmployeeStatus.ACTIVE;
                    case "inactive":
                        return EmployeeStatus.INACTIVE;
                    case "onleave":
                        return EmployeeStatus.ONLEAVE;
                    case "policyleave":
                        return EmployeeStatus.POLICYLEAVE;
                    default:
                        throw new IllegalArgumentException("Invalid status! Please enter active, inactive, onleave, or policyleave.");
                }
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
