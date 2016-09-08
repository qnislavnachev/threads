package task3;

public class Demo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Threads thread1 = new Threads(10, counter);
        Threads thread2 = new Threads(10, counter);

        thread1.start();
        thread2.start();
    }
}