import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        SharedData sharedData = new SharedData();
        Thread writer = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                synchronized (sharedData){
                    sharedData.setMessage("Message " + i);
                    sharedData.notify();
                }
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        });
        Thread reader = new Thread(() -> {
             while(true){
                 synchronized (sharedData){
                     try{
                         if(sharedData.getMessage() == null){
                             sharedData.wait();
                         }
                         System.out.println(sharedData.getMessage());
                         sharedData.setMessage(null);
                     }catch(InterruptedException e){
                         throw new RuntimeException(e);
                     }
                 }
             }
        });

        writer.start();
        reader.start();
    }
}