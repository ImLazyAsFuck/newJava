import java.io.*;

public class Main{
    public static void main(String[] args){
        Student student = new Student("Nguyễn Văn A", 20, 8.5);
        writeStudent(student);
        readStudent();
    }

    public static void writeStudent(Student student){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file student.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readStudent(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))) {
            Student readStudent = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file student.dat");
            System.out.println(readStudent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}