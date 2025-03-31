import java.util.InputMismatchException;
import java.util.Scanner;

public class B1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 1;
        double result = 0;
        try{
            System.out.print("Enter the first number: ");
            a = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the second number: ");
            b = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.err.println("a and b must be number");
        }finally{
            try{
                result = a / b;
                System.out.println("The result is: " + result);
            }catch(ArithmeticException e){
                System.err.println("Cannot divide by zero");
            }
         }
    }
}
