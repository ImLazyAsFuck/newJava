public class Reader extends Thread{
    private final SharedData sharedData;

    public Reader(SharedData sharedData){
        this.sharedData = sharedData;
    }

    @Override
    public synchronized void run(){
        while(true){
            synchronized(sharedData){
                try{
                    if(sharedData.getMessage() != null){
                        System.out.println("No message");
                        wait();
                    }
                    System.out.println(sharedData.getMessage());
                    break;
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
