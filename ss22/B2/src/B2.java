import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class B2{
    public static void main(String[] args) throws IOException{
        File file = new File("B2/src/data.txt");
        if(!file.exists()){
            if(file.createNewFile()){
                System.out.println("File created");
            }else{
                System.out.println("Can't not create file");
            }
        }else{
            System.out.println("File already exists");
        }
    }
}