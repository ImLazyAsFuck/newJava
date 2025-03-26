import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class B5{
    public static void main(String[] args){
        List<String> list = new ArrayList<>(Arrays.asList("Alice", "Andrew", "Bob", "Charlie"));
        Predicate<String > predicate = s -> s.startsWith("A") && s.length() >= 5;
        int count = 0;
        for(String s : list){
            if(predicate.test(s)){
                count++;
            }
        }
        System.out.println(count);
    }
}
