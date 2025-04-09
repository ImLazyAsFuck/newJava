public class Main {
    public static void main(String[] args) {
        BookingService service = new BookingService();

        Thread t1 = new Thread(() -> service.bookRoom(1, 101));
        Thread t2 = new Thread(() -> service.bookRoom(2, 101));

        t1.start();
        t2.start();
    }
}
