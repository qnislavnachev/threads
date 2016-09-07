package task2;

public class Threads extends Thread {
    private String threadName;
    private int countTo;
    private int sleepTime;
    private int counter = 0;
    private Threads thread;

    public Threads(String threadName, int countTo, int sleepTime) {
        this.threadName = threadName;
        this.countTo = countTo;
        this.sleepTime = sleepTime;
    }

    public void hasToInterrupt(Threads thread) {
        this.thread = thread;
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
            counter++;
            System.out.println(threadName + ": " + counter);
        }
        thread.interrupt();
    }
}
