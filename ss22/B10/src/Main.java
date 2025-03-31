import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main{
    private static final String FILE_PATH = "students.dat";
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Student findTopStudent() {
        return students.stream().max(Comparator.comparingDouble(Student::getGpa)).orElse(null);
    }

    public static List<Student> searchByMajor(String major) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                result.add(s);
            }
        }
        return result;
    }

    public static double calculateAverageGpa() {
        return students.stream().mapToDouble(Student::getGpa).average().orElse(0.0);
    }

    public static void displayStudents() {
        students.forEach(System.out::println);
    }

    public static void main(String[] args) {
        loadFromFile();
        System.out.println("Adding students...");
        addStudent(new Student(1, "Hoa", "Computer Science", 3.8));
        addStudent(new Student(2, "Linh", "Mathematics", 3.6));
        addStudent(new Student(3, "Hoàng", "Computer Science", 3.9));
        displayStudents();
        System.out.println("\nTop Student: " + findTopStudent());
        System.out.println("\nStudents in Computer Science: " + searchByMajor("Computer Science"));
        System.out.println("\nAverage GPA: " + calculateAverageGpa());
    }
}