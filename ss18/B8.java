import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class B8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> romanMap = new LinkedHashMap<>();

        int number;

        while(true){
            System.out.print("Enter number: ");
            number = Integer.parseInt(sc.nextLine());
            if(number <= 0 || number > 4000){
                System.out.println("Invalid number. Please choose from 0 to 4000.");
                continue;
            }
            break;
        }

        StringBuffer romanNumber = new StringBuffer();

        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        for(Map.Entry<Integer, String> entry : romanMap.entrySet()){
            while(number >= entry.getKey()){
                romanNumber.append(entry.getValue());
                number -= entry.getKey();
            }
        }

        System.out.println(romanNumber);
    }
}
