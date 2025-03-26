import java.util.List;

public class ListProcessorImpl implements ListProcessor{

    @Override
    public boolean containsNegative(List<Integer> list){
        for(Integer i : list){
            if(i < 0){
                return true;
            }
        }
        return false;
    }
}
