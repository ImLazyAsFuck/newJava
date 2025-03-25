import java.util.*;

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

        List<int[]> sortedList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            sortedList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j)[1] > sortedList.get(j + 1)[1]) {
                    int[] temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }

        System.out.println("Các phần tử theo số lần xuất hiện tăng dần:");
        for (int[] entry : sortedList) {
            System.out.println(entry[0] + " : " + entry[1]);
        }
    }
}
