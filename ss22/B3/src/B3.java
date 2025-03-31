import java.io.*;

public class B3{
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new FileReader("B3/src/copy.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            System.err.println("Error reading file");
        }
    }
}