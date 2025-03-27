import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B2{
    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10)
        );
        System.out.println("Tổng số lẻ: ");
        numbers.stream()
                .filter(x -> x % 2 != 0)
                .reduce(Integer::sum);
    }
}
