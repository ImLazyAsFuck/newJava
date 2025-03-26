import java.util.Scanner;

public class B3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Vui lòng nhập số nguyên a: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Vui lòng nhập số nguyên b: ");
        int b = Integer.parseInt(sc.nextLine());

        AddOperator addOperator = MathOperations::add;
        SubtractOperator subOperator = MathOperations::subtract;
        MultiplyOperator multiplyOperator = MathOperations::multiply;
        DivOperator divOperator = MathOperations::div;
        System.out.println();
        System.out.println(addOperator.apply(a,b));
        System.out.println(subOperator.apply(a,b));
        System.out.println(multiplyOperator.apply(a,b));
        System.out.println(divOperator.apply(a,b));
    }
}
