import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B6{
    public static void main(String[] args){
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> counts = items.stream()
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(LocalTime.now());
        counts.forEach((k,v)-> System.out.println(k+":"+v));
    }
}
