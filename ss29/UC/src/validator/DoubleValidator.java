package validator;

import java.util.Scanner;

public class DoubleValidator{
    public static double validateInteger(Scanner input, String message, int min){
        while(true){
            try{
                System.out.print(message);
                double doubleNumber = Double.parseDouble(input.nextLine());
                if(doubleNumber <= min){
                    throw new IllegalArgumentException("Input must be greater than " + min);
                }
                return doubleNumber;
            }catch(NumberFormatException e){
                System.out.println("\u001B[31mPlease enter a number\u001B[31m");
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31m" + e.getMessage() + "\u001B[31m");
            }
        }
    }
}
