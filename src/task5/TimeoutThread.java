package task5;

import java.util.Map;

public class TimeoutThread<K, V> extends Thread {
    private Map<K, V> table;
    private CountingTable<K> countingTable;
    private int timeout;

    public TimeoutThread(Map<K, V> table, CountingTable<K> countingTable, int timeout) {
        this.table = table;
        this.countingTable = countingTable;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (!table.isEmpty()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted !");
            }
            for (K each : countingTable.keyList()) {
                countingTable.put(each, (countingTable.get(each) + 1));
                if (countingTable.get(each) == timeout) {
                    table.remove(each);
                    System.out.println("Item is removed!");
                }
            }
        }
    }
}