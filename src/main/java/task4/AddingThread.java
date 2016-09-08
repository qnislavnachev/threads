package task4;

public class AddingThread extends Thread {
    public final MyList list;
    private int count = 0;

    public AddingThread(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (count <= 10) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
            list.insert(5);
            count++;
        }
    }
}
