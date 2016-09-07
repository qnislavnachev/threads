package task2;

public class Demo {
    public static void main(String[] args) {
        Threads thread1 = new Threads("Thread-1", 10, 1000);
        Threads thread2 = new Threads("Thread-2", 15, 1500);
        thread1.hasToInterrupt(thread2);
        thread2.hasToInterrupt(thread1);
        thread1.start();
        thread2.start();
    }
}