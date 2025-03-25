import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Map<String, Double> studentScores = new HashMap<String, Double>();
        for(int i = 0; i < 5; i++){
            System.out.println("Enter the " + (i + 1) + " student and score: ");
            String studentName = input.nextLine();
            while(true){
                double studentScore = Double.parseDouble(input.nextLine());
                if(studentScore <= 10 && studentScore >= 0){
                    studentScores.put(studentName, studentScore);
                    break;
                }
                System.err.println("Invalid score");
            }
        }
        for(Map.Entry<String, Double> entry : studentScores.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
        System.out.print("Enter the student name: ");
        String name = input.nextLine();
        for(Map.Entry<String, Double> entry : studentScores.entrySet()){
            if(entry.getKey().equals(name)){
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
