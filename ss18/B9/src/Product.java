import java.util.Scanner;

public class Product{
    private int productId;
    private String productName;
    private float productPrice;
    private int productQuantity;

    public Product(){
    }

    public Product(int productId, String productName, float productPrice, int productQuantity){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }

    public int getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public float getProductPrice(){
        return productPrice;
    }

    public int getProductQuantity(){
        return productQuantity;
    }

    public void inputData(Scanner input){
        System.out.print("Enter product name: ");
        this.productName = input.nextLine();
        System.out.print("Enter product price: ");
        this.productPrice = Float.parseFloat(input.nextLine());
        System.out.print("Enter product quantity: ");
        this.productQuantity = Integer.parseInt(input.nextLine());
    }

    public void updateProduct(Scanner input){
        System.out.print("Enter product name: ");
        this.productName = input.nextLine();
        System.out.print("Enter product price: ");
        this.productPrice = Float.parseFloat(input.nextLine());
        System.out.print("Enter product quantity: ");
        this.productQuantity = Integer.parseInt(input.nextLine());
    }

}
