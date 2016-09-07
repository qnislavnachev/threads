package task4;

public class RemoveThread extends Thread {
    public final MyList list;
    private int count = 0;

    public RemoveThread(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (count <= 10) {
            try {
                list.remove();
                count++;
                sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
    }
}
