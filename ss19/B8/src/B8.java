import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B8{
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 7, 10, 13, 6, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
        ListProcessorImpl processor = new ListProcessorImpl();
        processor.checkOdd(list);
        System.out.println("Tổng các số lẻ: " + processor.sumOddNumbers(list));
        processor.checkOdd(list2);
        System.out.println("Tổng các số lẻ: " + processor.sumOddNumbers(list2));
    }
}
