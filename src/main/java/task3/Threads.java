package task3;

public class Threads extends Thread {
    private final String threadName;
    private final int countTo;
    private final int sleepTime;
    private int counter = 0;
    private final Counter count;

    public Threads(String threadName, int countTo, int sleepTime) {
        this.threadName = threadName;
        this.countTo = countTo;
        this.sleepTime = sleepTime;
        count = new Counter();
    }

    @Override
    public void run() {
        while (counter < countTo) {
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupt.");
                return;
            }
            synchronized (count){
            counter = counter + count.increment(0);
            System.out.println(threadName + ": " + counter);
            }
        }
    }
}
