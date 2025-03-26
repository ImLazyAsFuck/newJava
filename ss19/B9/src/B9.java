import java.util.ArrayList;
import java.util.List;

public class B9{
    public static void main(String[] args){
        List<Product> productList = new ArrayList<>();
        ProductProcessorImpl productProcessor = new ProductProcessorImpl();
        productList.add(new Product("EZ", 23.5f));
        productList.add(new Product("Hello", 101f));

        if(!productProcessor.hasExpensiveProducts(productList)){
            System.out.println("Không có sản phẩm đắt tiền.");
        }else{
            System.out.println("Danh sách sản phẩm có giá trên 100: ");
            for(Product p : productList){
                if(p.getPrice() > 100){
                    System.out.println(p);
                }
            }
            System.out.println();
        }

        System.out.println("Tổng giá trị các sản phẩm" + productProcessor.calculateTotalValue(productList));
        System.out.println();
        System.out.println("Danh sách sản phẩm: ");
        ProductProcessor.printProductList(productList);
    }
}
