package task3;

public class Counter implements Runnable {
    private int countTo;
    private final Object lock;

    public Counter(int countTo, Object lock) {
        this.countTo = countTo;
        this.lock = lock;
    }

    public void run() {
        int counter = 0;
        synchronized (lock) {
            while (countTo > counter) {
                counter++;
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }
            }
            lock.notifyAll();
        }
    }
}