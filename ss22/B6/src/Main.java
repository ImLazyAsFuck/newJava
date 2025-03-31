import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args){
        File file = new File("B6/src/input.txt");
        StringBuilder text = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                text.append(line);
            }
            System.out.println(text.reverse());
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}