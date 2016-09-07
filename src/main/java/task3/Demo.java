package task3;

public class Demo {
    public static void main(String[] args) {
        Threads thread1 = new Threads("Thread-1", 10 , 1000);
        Threads thread2 = new Threads("Thread-2", 10 , 1000);
        thread1.start();
        thread2.start();
    }
}