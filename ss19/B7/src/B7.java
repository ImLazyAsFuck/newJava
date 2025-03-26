import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B7{
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(5, -2, 10, 0, -7, -3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5, 6, 7));
        ListProcessorImpl lp = new ListProcessorImpl();
        if(lp.containsNegative(list)){
            System.out.println("Danh sách chứa số âm");
        }else{
            System.out.println("Danh sách không chứa số âm");
        }
        if(lp.containsNegative(list2)){
            System.out.println("Danh sách chứa số âm");
        }else{
            System.out.println("Danh sách không chứa số âm");
        }
    }
}
