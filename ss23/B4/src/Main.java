public class Main{
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread::run);
        Thread thread2 = new Thread(() -> System.out.println("Thread 2 bắt đầu"));
        Thread thread3 = new Thread(() -> System.out.println("Thread 3 bắt đầu"));

        thread1.start();
        try{
            thread1.join();
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        thread2.start();
        try{
            thread2.join();
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        thread3.start();
    }
}