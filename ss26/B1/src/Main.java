public class Main{
    public static void main(String[] args){
        Account acc1 = Account.getInstance(1, "Alice", 25);
        Account acc2 = Account.getInstance(2, "Bob", 30);

        acc1.display();
        acc2.display();

        System.out.println("acc1 == acc2: " + (acc1 == acc2));
    }
}