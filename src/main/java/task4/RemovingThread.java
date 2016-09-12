package task4;

public class RemovingThread extends Thread {
    public final MyList list;
    private int count = 0;
    private int limit;

    public RemovingThread(MyList list, int limit) {
        this.list = list;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (count <= limit) {
            list.remove();
            count++;
        }
    }
}
