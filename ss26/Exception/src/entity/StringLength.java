package entity;

public class StringLength{
    private int minLength;
    private int maxLength;

    public StringLength(int minLength, int maxLength){
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public int getMinLength(){
        return minLength;
    }

    public int getMaxLength(){
        return maxLength;
    }
}
