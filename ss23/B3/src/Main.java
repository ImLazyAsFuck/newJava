public class Main{
    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(sharedResource::printAlphabet);
        Thread thread2 = new Thread(sharedResource::printAlphabet);
        thread1.setName("1");
        thread2.setName("2");
        thread1.start();
        thread2.start();
    }
}