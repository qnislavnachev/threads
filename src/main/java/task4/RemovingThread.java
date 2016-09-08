package task4;

public class RemovingThread extends Thread {
    public final MyList list;
    private int count = 0;

    public RemovingThread(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (count <= 10) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
            list.remove();
            count++;
        }
    }
}
