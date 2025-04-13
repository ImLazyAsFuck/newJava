package bussiness.model;

public class LengthConstraint{
    private int min;
    private int max;

    public LengthConstraint(int min, int max){
        this.min = min;
        this.max = max;
    }

    public LengthConstraint(){
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }
}
