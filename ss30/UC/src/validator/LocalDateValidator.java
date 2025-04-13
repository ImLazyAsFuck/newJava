package validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class LocalDateValidator{

    public static LocalDate validateDate(Scanner input, String message, String regex) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            try {
                System.out.print(message);
                String dateInput = input.nextLine().trim();
                if (!dateInput.matches(regex)) {
                    throw new IllegalArgumentException("Date must match format dd/MM/yyyy!");
                }
                return LocalDate.parse(dateInput, formatter);
            } catch (DateTimeParseException | IllegalArgumentException e) {
                System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
