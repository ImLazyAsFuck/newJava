import java.util.List;

public class ListProcessorImpl implements ListProcessor {
    @Override
    public int sumOddNumbers(List<Integer> list){
        int sumOdd = 0;
        for(Integer i : list){
            if(i % 2 != 0){
                sumOdd += i;
            }
        }
        return sumOdd;
    }

    @Override
    public void checkOdd(List<Integer> list){
        ListProcessor.super.checkOdd(list);
    }
}
