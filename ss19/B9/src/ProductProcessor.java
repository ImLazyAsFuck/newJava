import java.util.List;

public interface ProductProcessor{
    float calculateTotalValue(List<Product> productList);

    static void printProductList(List<Product> productList){
        productList.forEach(p -> System.out.println(p.toString()));
    }
}
