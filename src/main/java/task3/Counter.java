package task3;

public class Counter {

    public synchronized void count(int countTo, int counter) {
        while (countTo > counter) {
            counter++;
            System.out.println(Thread.currentThread().getName() + ": " + counter);
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("I was interrupted!");
            }
        }
        notifyAll();
    }
}
