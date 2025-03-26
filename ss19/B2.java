import java.util.function.Function;

public class B2{
    public static void main(String[] args){
        Function<Integer, Integer> f = x -> x * x + 3 * x + 2;
        System.out.println(f.apply(1));
        System.out.println(f.apply(2));
        System.out.println(f.apply(3));
    }
}
