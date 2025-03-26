import java.util.List;

public interface ListProcessor{
    boolean containsNegative(List<Integer> list);
    static void printList(List<Integer> list){
        for(Integer i : list){
            System.out.println(i);
        }
    }
}
