import java.util.ArrayList;
import java.util.List;

public class B6{
    public static void main(String[] args){
        List<String> strings = new ArrayList<>(List.of("Hello World", "124534", "Not a number", "223344"));
        List<Integer> validNumbers = new ArrayList<>();
        List<String> stringlist = new ArrayList<>();
        for(String s : strings){
            try{
                validNumbers.add(Integer.parseInt(s));
            }catch(NumberFormatException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println(validNumbers);
    }
}
