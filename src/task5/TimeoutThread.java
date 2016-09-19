package task5;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class TimeoutThread<K, V> extends Thread {
    private Hashtable<K, V> table;
    private LinkedHashMap<K, Long> countingTable;
    private long timeout;

    public TimeoutThread(Hashtable<K, V> table, LinkedHashMap<K, Long> countingTable, long timeout) {
        this.table = table;
        this.countingTable = countingTable;
        this.timeout = timeout;
    }

    private boolean isExpired(K key) {
        long currentTime = System.currentTimeMillis();
        long timeExpire = currentTime - countingTable.get(key);
        return timeExpire > timeout;
    }

    private void removeExpireKey(K key) {
        if (isExpired(key)) {
            table.remove(key);
            countingTable.remove(key);
            System.out.println("Key was removed : " + key);
        }
    }

    @Override
    public void run() {
        while (!table.isEmpty()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted !");
            }
            Iterator<K> it = countingTable.keySet().iterator();
            K key = it.next();
            removeExpireKey(key);
        }
    }
}