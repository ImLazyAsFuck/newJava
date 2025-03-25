import java.util.*;

public class ProductManagement{
    public static Map<Integer, Product> products = new HashMap<Integer, Product>();

    public static void addProduct(Scanner input){
        Product newProduct = new Product();
        while(true){
            System.out.print("Enter product id: ");
            int id = Integer.parseInt(input.nextLine());
            if (products.containsKey(id)) {
                System.out.println("Product already exists. Please try again.");
                continue;
            }
            newProduct.setProductId(id);
            break;
        }
        newProduct.inputData(input);
        products.put(newProduct.getProductId(), newProduct);
        System.out.println("Product added successfully");
    }

    public static void updateProduct(Scanner input){
        for(Map.Entry<Integer, Product> entry : products.entrySet()){
            System.out.println("ID" + entry.getKey() + " : Name" + entry.getValue().getProductName());
        }

        System.out.print("Enter product ID: ");
        int productId = Integer.parseInt(input.nextLine());
        for(Map.Entry<Integer, Product> entry : products.entrySet()){
            if(entry.getValue().getProductId() == productId){
                entry.getValue().updateProduct(input);
            }
        }
    }

    public static void productValueCalculation(){
        if(products.isEmpty()){
            System.out.println("No product found");
            return;
        }
        float sum = 0;
        for(Map.Entry<Integer, Product> entry : products.entrySet()){
            System.out.println("product " + entry.getKey() + ": " + entry.getValue().getProductPrice() * (float)entry.getValue().getProductQuantity());
            sum += entry.getValue().getProductPrice() * (float)entry.getValue().getProductQuantity();
        }
        System.out.println("Sum of product values: " + sum);
    }

    public static void removeProduct(Scanner input){
        if(products.isEmpty()){
            System.out.println("Product list is empty");
            return;
        }
        for(Map.Entry<Integer, Product> entry : products.entrySet()){
            System.out.println("ID" + entry.getKey() + " : Name: " + entry.getValue().getProductName());
        }

        System.out.print("Enter product ID: ");
        int productId = Integer.parseInt(input.nextLine());

        if(products.get(productId).getProductId() == productId){
            products.remove(productId);
            System.out.println("Product removed successfully");
        }
    }
}
