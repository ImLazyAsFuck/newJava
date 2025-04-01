public class Main{
    public static void main(String[] args){
        Thread thread = new Thread(new B2Runnable());
        thread.setName("B2 Thread");
        thread.start();
    }
}