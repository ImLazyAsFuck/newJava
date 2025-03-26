import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B6{
    public static void main(String[] args){
        List<String> list = new ArrayList<String>(Arrays.asList("java", "lambda", "stream", "functional"));
        StringProcessor stringProcessor = input -> input.toUpperCase().concat(" - TECHNICAL");
        list.forEach(stringProcessor::processString);
        for(String string : list){
            System.out.print(string + " ");
        }
    }
}
