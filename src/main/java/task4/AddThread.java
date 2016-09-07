package task4;

public class AddThread extends Thread {
    public final MyList list;
    private int count = 0;

    public AddThread(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (count <= 10) {
            try {
                list.insert(5);
                count++;
                sleep(1000);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
