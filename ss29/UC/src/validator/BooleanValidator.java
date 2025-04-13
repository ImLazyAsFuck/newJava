package validator;

import java.util.Scanner;

public class BooleanValidator{
    public static boolean validateBoolean(Scanner input, String message){
        while(true){
            try{
                System.out.print(message);
                String bool = input.nextLine();
                if(bool.trim().isEmpty()){
                    throw new IllegalArgumentException("Boolean cannot be empty");
                }
                if(bool.equalsIgnoreCase("true") || bool.equalsIgnoreCase("false")){
                    return Boolean.parseBoolean(bool);
                }
                throw new IllegalArgumentException("Invalid boolean value! please choose true or false");
            }catch(IllegalArgumentException e){
                System.out.println("\u001B[31m" + e.getMessage() + "\u001B[31m");
            }
        }
    }
}
