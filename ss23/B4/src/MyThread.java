public class MyThread implements Runnable{
    @Override
    public synchronized void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Thread 1: " + (i + 1) + " ");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
