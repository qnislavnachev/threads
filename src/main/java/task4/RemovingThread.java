package task4;

public class RemovingThread extends Thread {
    public final MyList list;
    private int count = 0;
    private int limit;
    private int index;

    public RemovingThread(MyList list, int limit, int index) {
        this.list = list;
        this.limit = limit;
        this.index = index;
    }

    @Override
    public void run() {
        while (count <= limit) {
            list.remove(index);
            count++;
        }
    }
}
