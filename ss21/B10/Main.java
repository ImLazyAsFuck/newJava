package B10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Product product1 = new Product("P001", "Laptop", 1500.0);
        Product product2 = new Product("P002", "Phone", 800.0);
        Product product3 = new Product("P003", "Headphones", 150.0);
        List<Product> products = new ArrayList<Product>(Arrays.asList(product1, product2, product3));
        int choice;
        while(true){
            System.out.println("------------------- Menu ---------------------");
            System.out.println("2. Display Products");
            System.out.println("1. Add Product To Cart");
            System.out.println("3. Delete Product From Cart");
            System.out.println("4. Display Cart");
            System.out.println("5. Display Total Price");
            System.out.println("6. Exit");
            try{
                choice = Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Invalid input");
                continue;
            }
            switch(choice){
                case 1:
                    System.out.println("Product List: ");
                    for(Product p : products){
                        System.out.println(p);
                    }
                    break;
                case 2:
                    for(Product p : products){
                        System.out.println("ID: " + p.getId() + " Name: " + p.getName());
                    }
                    try{
                        Product selectedProduct = null;
                        System.out.print("Enter product ID:");
                        String productId = sc.nextLine();
                        if(productId.equalsIgnoreCase("P001")){
                            selectedProduct = product1;
                        }else if(productId.equalsIgnoreCase("P002")){
                            selectedProduct = product2;
                        }else if(productId.equalsIgnoreCase("P003")){
                            selectedProduct = product3;
                        }
                        if(selectedProduct == null){
                            throw new Exception("Product is not found");
                        }
                        System.out.println("Enter quantity: ");
                        try{
                            int quantity = Integer.parseInt(sc.nextLine());
                            ShoppingCart.addCartItem(selectedProduct, quantity);
                        }catch(NumberFormatException e){
                            System.out.println("Invalid input");
                        }
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                    case 3:
                        System.out.print("Enter product ID:");
                        String productId = sc.nextLine();
                        ShoppingCart.removeCartItem(productId);
                        break;
                case 4:
                    ShoppingCart.displayCartItems();
                    break;
                case 5:
                    ShoppingCart.checkout();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
