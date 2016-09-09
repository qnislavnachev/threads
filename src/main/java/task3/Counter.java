package task3;

public class Counter implements Runnable {
    private int countTo;

    public Counter(int countTo) {
        this.countTo = countTo;
    }

    public void run() {
        int counter = 0;
        synchronized (this) {
            while (countTo > counter) {
                counter++;
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }
            }
            notifyAll();
        }
    }
}