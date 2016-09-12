package task3;

public class Demo {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread1 = new Thread(new Counter(10, lock));
        Thread thread2 = new Thread(new Counter(10, lock));

        thread1.start();
        thread2.start();
    }
}