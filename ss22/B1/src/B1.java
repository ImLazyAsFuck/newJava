import java.io.*;
import java.util.Scanner;

public class B1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter something: ");
        String s = sc.nextLine();
        writeToFile(s);
        readToFile();
    }

    public static void writeToFile(String text){
        File file = new File("B1/src/output.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(text);
            oos.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(oos != null){
            try{
                oos.close();
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        if(fos != null){
            try{
                fos.close();
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void readToFile(){
        File file = new File("B1/src/output.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        StringBuffer output = new StringBuffer();
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            output.append((String)ois.readObject());
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (ois != null) {
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
