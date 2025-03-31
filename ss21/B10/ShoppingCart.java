package B10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart{
    public static List<CartItem> cartItems = new ArrayList<CartItem>();

    public static void addCartItem(Product product, int quantity){
        try{
            if(quantity <= 0){
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }
            for(CartItem item : cartItems){
                if(item.getProduct().getId().equals(product.getId())){
                    item.setQuantity(item.getQuantity() + quantity);
                    System.out.println("Item already exists, increased quantity successfully");
                    return;
                }
            }
            cartItems.add(new CartItem(product, quantity));
            System.out.println("New cart item added successfully");
        }catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    public static void removeCartItem(String productId){
        try{
            boolean found = false;
            for(CartItem item : cartItems){
                if(item.getProduct().getId().equals(productId)){
                    cartItems.remove(item);
                    found = true;
                    break;
                }
            }
            if(!found){
                throw new Exception("Product not found");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void displayCartItems(){
        try{
            if(cartItems.isEmpty()){
                throw new Exception("Cart is empty");
            }
            System.out.println("Cart items:");
            for(CartItem item : cartItems){
                System.out.println(item);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void checkout(){
        try{
            if(cartItems.isEmpty()){
                throw new Exception("Cart is empty");
            }
            double total = 0.0;
            for(CartItem item : cartItems){
                total = item.getProduct().getPrice() * item.getQuantity();
            }
            System.out.println("Total price: " + total);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
