package task1;

public class CountingThread extends Thread {
    private int count = 0;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted at: " + count);
                return;
            }
            count++;
        }
    }

    /**
     * stop a thread
     */
    public void stopCounting() {
        flag = false;
    }
}