import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagement {
    private static final String FILE_PATH = "B9/src/books.dat";
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        loadBooks();

        System.out.println("Adding a new book...");
        addBook(new Book(6, "Overlord", "Kugane Maruyama", "Enterbrain", 130000.0));
        displayBooks();

        System.out.println("\nUpdating book with ID 6...");
        updateBook(new Book(6, "Overlord", "Kugane Maruyama", "Kadokawa", 135000.0));
        displayBooks();

        System.out.println("\nDeleting book with ID 6...");
        deleteBook(6);
        displayBooks();
    }

    public static void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public static void updateBook(Book book) {
        books.replaceAll(b -> b.getId() == book.getId() ? book : b);
        saveBooks();
    }

    public static void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
        saveBooks();
    }

    public static void displayBooks() {
        books.forEach(System.out::println);
    }

    private static void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadBooks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            books = (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
