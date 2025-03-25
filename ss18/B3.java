import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class B3{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Map<String, Float> products = new LinkedHashMap<>();
        products.put("Laptop", 4000.00f);
        products.put("Phone", 5000.00f);
        products.put("Samsung Galaxy", 12000.00f);
        products.put("Sony Galaxy", 12000.00f);
        products.put("Iphone XS max", 12000.00f);

        for(Map.Entry<String, Float> entry : products.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        for(Map.Entry<String, Float> entry : products.entrySet()){
            if(entry.getKey().equals("Laptop")){
                entry.setValue(entry.getValue() * 0.9f);
            }
        }
        products.remove("Phone");

    }
}
