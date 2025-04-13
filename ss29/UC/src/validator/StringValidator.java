package validator;

import bussiness.model.LengthConstraint;

import java.util.Scanner;

public class StringValidator{
    public static String validate(Scanner input, String message, LengthConstraint length){
        while(true){
            try{
                System.out.print(message);
                String s = input.nextLine().trim();
                if(s.isEmpty()){
                    throw new IllegalArgumentException("String can't be empty");
                }
                if(length.getMin() > s.length()){
                    throw new IllegalArgumentException("String must be less than " + length.getMin() + " characters");
                }
                if(length.getMax() < s.length()){
                    throw new IllegalArgumentException("String must be greater than " + length.getMax() + " characters");
                }
                return s;
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31m" + e.getMessage() + "\u001B[31m");
            }
        }
    }
}
