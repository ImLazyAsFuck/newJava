import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Map<String, Double> products = new HashMap<>();
        products.put("Laptop", 3000.00);
        products.put("Ipad", 1000.00);
        products.put("Oslo", 2000.00);
        products.put("Iphone XS Supreme max", 1000.00);
        products.put("Samsung Galaxy Note 10", 2000.00);

        for(Map.Entry<String, Double> entry : products.entrySet()){
            if(entry.getKey().equals("Laptop")){
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
