import java.util.Scanner;

public class B4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            int integer = Integer.parseInt(sc.nextLine());
            System.out.println("Bạn đã nhập: " + integer);
        }catch(NumberFormatException e){
            System.err.println("Lỗi: Bạn phải nhập số nguyên!");
        }finally{
            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
        }
    }
}
