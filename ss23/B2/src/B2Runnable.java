public class B2Runnable implements Runnable{
    @Override
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.print(i + " ");
        }
    }
}
