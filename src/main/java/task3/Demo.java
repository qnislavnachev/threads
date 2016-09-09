package task3;

public class Demo {
    public static void main(String[] args) {
        Counter counter = new Counter(10);
        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(counter);

        thread1.start();
        thread2.start();
    }
}