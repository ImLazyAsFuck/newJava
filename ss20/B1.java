import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B1 {
    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10)
        );
        System.out.print("Danh sách số chẵn: ");
        numbers.stream().
                filter(x -> x % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }
}
