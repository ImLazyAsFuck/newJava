import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class B1 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>(Arrays.asList("Java", "", "Lambda", "Stream", "", "Functional"));
        Predicate<String> predicate = s -> !s.trim().isEmpty();
        list.forEach(s -> {
            if(predicate.test(s)){
                System.out.print(s + " ");
            }
        });
    }
}
