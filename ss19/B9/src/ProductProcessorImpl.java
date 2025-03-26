import java.util.List;

public class ProductProcessorImpl implements ProductProcessor {
    @Override
    public float calculateTotalValue(List<Product> productList){
        if(productList.isEmpty()){
            return 0f;
        }
        float total = 0f;
        for(Product p : productList){
            total += p.getPrice();
        }
        return total;
    }

    public boolean hasExpensiveProducts(List<Product> productList){
        for(Product p : productList){
            if(p.getPrice() > 100){
                return true;
            }
        }
        return false;
    }
}
