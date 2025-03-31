import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        List<Product> products = List.of(
                new Product(1, "Laptop", 1200.0),
                new Product(2, "Phone", 800.0),
                new Product(3, "Tablet", 500.0)
        );
        writeBinary(products);
        readBinary();
    }

    public static void writeBinary(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.dat"))) {
            oos.writeObject(products);
            System.out.println("Written " + products.size() + " products to binary file.");
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
        }
    }

    public static void readBinary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("products.dat"))) {
            List<Product> products = (List<Product>) ois.readObject();
            System.out.println("Products from file:");
            products.forEach(product ->
                    System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice()));
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while reading file: " + e.getMessage());
        }
    }
}