public class Main{
    public static void main(String[] args){
        Thread thread = new NewThread();
        thread.setName("New Thread");
        thread.start();
    }
}