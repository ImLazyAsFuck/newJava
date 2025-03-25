import java.util.*;

public class B5{
    public static void main(String[] args){
        Map<String, Integer> products = new HashMap<>();
        products.put("Laptop", 1200);
        products.put("Bàn phím", 300);
        products.put("Chuột", 600);
        products.put("Màn hình", 1500);
        products.put("Tai nghe", 900);
        products.put("Loa", 400);
        products.put("Ổ cứng", 1300);

        List<Map.Entry<String, Integer>> filteredProducts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue() >= 500 && entry.getValue() <= 1500) {
                filteredProducts.add(entry);
            }
        }

        for (int i = 0; i < filteredProducts.size() - 1; i++) {
            for (int j = i + 1; j < filteredProducts.size(); j++) {
                if (filteredProducts.get(i).getValue() > filteredProducts.get(j).getValue()) {
                    Map.Entry<String, Integer> temp = filteredProducts.get(i);
                    filteredProducts.set(i, filteredProducts.get(j));
                    filteredProducts.set(j, temp);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : filteredProducts) {
            System.out.println("Tên sản phẩm: " + entry.getKey() + " - Giá: " + entry.getValue());
        }
    }
}
