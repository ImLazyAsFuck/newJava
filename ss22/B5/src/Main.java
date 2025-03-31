import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "B5/src/input.txt";
        findLongestName(fileName);
    }

    private static void findLongestName(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            String longestName = "";
            for (String line : lines) {
                if (line.length() > longestName.length()) {
                    longestName = line;
                }
            }
            System.out.println("Tên cầu thủ có tên dài nhất: " + longestName);
            System.out.println("Độ dài của tên đó: " + longestName.length());
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}