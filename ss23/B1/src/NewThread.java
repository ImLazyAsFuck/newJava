public class NewThread extends Thread {

    @Override
    public void run(){
        System.out.println("Thread started: " + Thread.currentThread().getName());
    }
}
