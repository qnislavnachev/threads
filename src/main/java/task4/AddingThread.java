package task4;

public class AddingThread extends Thread {
    public final MyList list;
    private int count = 0;
    private int limit;

    public AddingThread(MyList list, int limit) {
        this.list = list;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (count <= limit) {
            list.insert(5);
            count++;
        }
    }
}
