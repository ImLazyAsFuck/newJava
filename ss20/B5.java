import java.util.List;
import java.util.Optional;

public class B5{
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList= List.of(10, 10, 10);

        for (List<Integer> numbers : List.of(normalList,singleElementList,allSameList)){
            Optional<Integer> secondLargetElement = numbers.stream()
                    .distinct()
                    .sorted()
                    .skip(1)
                    .findFirst();
            secondLargetElement.ifPresentOrElse(
                    num -> System.out.println("Số lớn thứ 2: " + num),
                    () -> System.out.println("Không có phần tử lớn thứ 2")
            );
        }
    }
}