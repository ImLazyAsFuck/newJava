package validator;

import java.util.Scanner;

public class IntegerValidator{
    public static int validateInteger(Scanner input, String message, int min){
        while(true){
            try{
                System.out.print(message);
                int integer = Integer.parseInt(input.nextLine());
                if(integer <= min){
                    throw new IllegalArgumentException("Input must be greater than " + min);
                }
                return integer;
            }catch(NumberFormatException e){
                System.out.println("\u001B[31mPlease enter a number\u001B[31m");
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31m" + e.getMessage() + "\u001B[31m");
            }
        }
    }
}
