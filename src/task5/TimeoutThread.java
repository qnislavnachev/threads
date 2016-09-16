package task5;

public class TimeoutThread extends Thread {
    private ObjectTable table;
    private int timeout;

    public TimeoutThread(ObjectTable table, int timeout) {
        this.table = table;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted !");
            }
            for (String each : table.getTable()) {
                table.getTimeoutTable().put(each, (table.getTimeoutTable().get(each) + 1));
                if (table.getTimeoutTable().get(each) == timeout) {
                    table.remove(each);
                    System.out.println("Item is removed!");
                }
            }
        }
    }
}