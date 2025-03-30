public class B3{
    public static void main(String[] args){
        checkAge(17);
    }

    public static void checkAge(int age){
        if(age < 18){
            throw new IllegalArgumentException("Bạn chưa đủ 18 tuổi!");
        }
        System.out.println("Chào mừng bạn");
    }
}
