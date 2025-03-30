import java.util.Scanner;

public class B2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int index = -1;
        try{
            index = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.err.println("index must be an integer");
        }finally{
            try{
                for(int i = 0; i<arr.length; i++){
                    if(arr[i] == index){
                        index = i;
                    }
                }
                System.out.println(arr[index]);
            }catch(IndexOutOfBoundsException e){
                System.err.println("Array index out of bounds");
            }
        };
    }
}
