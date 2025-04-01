public class SharedResource {
    public synchronized void printAlphabet(){
        System.out.println("Luồng" + Thread.currentThread().getName() + ": ");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
