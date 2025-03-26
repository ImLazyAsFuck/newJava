import java.util.List;

public interface ListProcessor{
    int sumOddNumbers(List<Integer> list);

    static void printList(List<Integer> list){
        list.forEach(System.out::println);
    }

    default void checkOdd(List<Integer> list){
        int count = 0;
        for(Integer i : list){
            if(i % 2 != 0){
                count++;
            }
        }
        if(count == 0){
            System.out.println("Không có phần tử lẻ.");
            return;
        }
        System.out.print("Các phần tử lẻ: ");
        for(Integer i : list){
            if(i % 2 != 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
