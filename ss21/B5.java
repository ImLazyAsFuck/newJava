import java.util.Scanner;

public class B5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            int n = Integer.parseInt(sc.nextLine());
            if(n <= 0){
                throw new IllegalArgumentException("Number must greater than 0");
            }
            if(isPrime(n)){
                System.out.println(n + " is prime number");
            }else{
                System.out.println(n + " is not prime number");
            }
        }catch(NumberFormatException e){
            System.out.println("Please enter a valid number");
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
