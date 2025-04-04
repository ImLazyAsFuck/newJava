package until;

import entity.StringLength;

import java.util.Scanner;

public class Validator{
    public static int integerValidate(Scanner sc, String message){
        while(true){
            try{
                System.out.print(message);
                int number = Integer.parseInt(sc.nextLine());
                return number;
            }catch(NumberFormatException e){
                System.out.println("Please enter a number");
            }
        }
    }

    public static float floatValidate(Scanner sc, String message){
        while(true){
            try{
                System.out.print(message);
                float number = Float.parseFloat(sc.nextLine());
                return number;
            }catch(NumberFormatException e){
                System.out.println("Please enter a float number");
            }
        }
    }

    public static double doubleValidate(Scanner sc, String message){
        while(true){
            try{
                System.out.print(message);
                double number = Double.parseDouble(sc.nextLine());
                return number;
            }catch(NumberFormatException e){
                System.out.println("Please enter a double number");
            }
        }
    }

    public static Boolean booleanValidate(Scanner sc, String message){
        while(true){
            try{
                System.out.print(message);
                String bool = sc.nextLine();
                if(bool.trim().isEmpty()){
                    throw new IllegalArgumentException("Bool cannot be empty");
                }
                if(bool.equalsIgnoreCase("true") || bool.equalsIgnoreCase("false")){
                    return Boolean.parseBoolean(bool);
                }
                throw new IllegalArgumentException("Please enter a boolean value");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String stringValidate(Scanner sc, String message, StringLength length){
        while(true){
            try{
                System.out.print(message);
                String string = sc.nextLine();
                if(string.trim().isEmpty()){
                    throw new IllegalArgumentException("String cannot be empty");
                }
                if(string.length() < length.getMinLength() || string.length() > length.getMaxLength()){
                    throw new IllegalArgumentException("String length should be between " + length.getMinLength() + " and " + length.getMaxLength());
                }
                return string;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String emailValidate(Scanner sc, String message){
        while(true){
            try{
                System.out.print(message);
                String email = sc.nextLine();
                if(email.trim().isEmpty()){
                    throw new IllegalArgumentException("Email cannot be empty");
                }
                if(!email.matches("^\\w+@\\w+.\\w+")){
                    throw new IllegalArgumentException("Email should be word@domain.com.*");
                }
                return email;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String phoneValidate(Scanner sc, String message){
        while(true){
            try{
                System.out.print(message);
                String phone = sc.nextLine();
                if(phone.trim().isEmpty()){
                    throw new IllegalArgumentException("Phone cannot be empty");
                }
                if(!phone.matches("^(0[3|5|7|8|9])\\d{8}$")){
                    throw new IllegalArgumentException("Phone number should start with 03 or 05 or 07 or 09 and 8 numbers");
                }
                return phone;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
