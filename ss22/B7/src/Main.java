import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.text;

public class Main{
    public static void main(String[] args) {
        String fileName = "B7/src/data.txt";
        List<Country> countryList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String code = parts[1].trim();
                    String name = parts[2].trim();
                    countryList.add(new Country(id, code, name));
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
        System.out.println("+-----+-------+-----------------+");
        System.out.println("| ID  | CODE  | COUNTRY         |");
        System.out.println("+-----+-------+-----------------+");
        for (Country country : countryList) {
            System.out.println(country);
        }
        System.out.println("+-----+-------+-----------------+");
    }
}