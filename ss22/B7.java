import java.util.Scanner;

public class B7{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int constantBalance = 10000000;
        System.out.print("How much do you want to withdraw: ");
        try{
            int withdraw = Integer.parseInt(scanner.nextLine());
            if(withdraw < 0){
                throw new ArithmeticException("Lỗi: Số tiền rút phải lớn hơn 0");
            }
            if(withdraw > constantBalance){
                throw new ArithmeticException("Lỗi: Số tiền rút vượt quá số dư!");
            }
            System.out.println(withdraw);
        }catch(NumberFormatException e){
            System.err.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        }catch(ArithmeticException e){
            System.err.println(e.getMessage());
        }
    }
}
