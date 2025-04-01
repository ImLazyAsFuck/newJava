public class Main {
    public static void main(String[] args) {
        PriorityThread t1 = new PriorityThread("Thread 1 (MIN_PRIORITY)");
        PriorityThread t2 = new PriorityThread("Thread 2 (NORM_PRIORITY)");
        PriorityThread t3 = new PriorityThread("Thread 3 (MAX_PRIORITY)");

        t1.setPriority(Thread.MIN_PRIORITY); 
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}