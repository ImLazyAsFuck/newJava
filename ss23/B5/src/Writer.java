public class Writer extends Thread{
    private final SharedData sharedData;

    public Writer(SharedData sharedData){
        this.sharedData = sharedData;
    }

    @Override
    public synchronized void run(){
        this.sharedData.setMessage("Something");
        notify();
    }
}
