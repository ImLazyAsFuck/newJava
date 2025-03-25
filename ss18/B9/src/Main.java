import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Menu");
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. Calculate product value");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch(choice){
                case 1:
                    ProductManagement.addProduct(input);
                    break;
                case 2:
                    ProductManagement.updateProduct(input);
                    break;
                case 3:
                    ProductManagement.removeProduct(input);
                    break;
                case 4:
                    ProductManagement.productValueCalculation();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}