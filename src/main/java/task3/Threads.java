package task3;

public class Threads extends Thread {
    private final int countTo;
    private int count = 0;
    private final Counter counter;

    public Threads(int countTo, Counter counter) {
        this.countTo = countTo;
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.count(countTo, count);
    }
}
