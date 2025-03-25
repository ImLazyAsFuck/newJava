import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(true){
            System.out.println("Enter N: ");
            n = Integer.parseInt(sc.nextLine());
            if(n <= 0){
                System.out.println("Invalid N");
                continue;
            }
            break;
        }
        int[] arr = new int[n];
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i = 0; i < n; i++){
            System.out.print("arr[" + i + "] :");
            arr[i] = Integer.parseInt(sc.nextLine());
            if(counts.containsKey(arr[i])){
                counts.put(arr[i], counts.get(arr[i]) + 1);
            }else{
                counts.put(arr[i], 1);
            }
        }
        counts.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
