public class Main {
    public static void main(String[] args) {
        AuctionService service = new AuctionService();

        service.placeBid(1, 1, 500);
        service.placeBid(2, 1, 300);
        service.placeBid(3, 1, 1000000);
        service.placeBid(1, 999, 600);
    }
}
