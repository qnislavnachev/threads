package task5;

import java.util.*;

public class TimeoutTable<K, V> {
    private Hashtable<K, V> table = new Hashtable<>();
    private LinkedHashMap<K, Long> countingTable = new LinkedHashMap<>();
    private long timeout;

    private Thread timeOutThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (!table.isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted !");
                }
                Iterator<K> it = countingTable.keySet().iterator();
                while (it.hasNext()) {
                    K key = it.next();
                    if (isExpired(key)) {
                        it.remove();
                        table.remove(key);
                        countingTable.remove(key);
                        System.out.println("Key was removed : " + key);
                    } else {
                        break;
                    }
                }
            }
        }
    });

    public TimeoutTable(long timeout) {
        this.timeout = timeout;
        timeOutThread.start();
    }

    public synchronized void put(K key, V value) {
        if (table.containsKey(key)) {
            table.put(key, value);
            countingTable.remove(key);
            countingTable.put(key, System.currentTimeMillis());
            System.out.println("Item was used : " + key);
        } else {
            table.put(key, value);
            countingTable.put(key, System.currentTimeMillis());
            System.out.println("New item added : " + key);
        }
    }

    public synchronized V get(K key) {
        if (table.containsKey(key)) {
            countingTable.remove(key);
            countingTable.put(key, System.currentTimeMillis());
            System.out.println("Item was used : " + key);
            return table.get(key);
        }
        return null;
    }

    public synchronized void remove(K key) {
        table.remove(key);
    }

    private boolean isExpired(K key) {
        long currentTime = System.currentTimeMillis();
        long timeExpire = currentTime - countingTable.get(key);
        return timeExpire > timeout;
    }
}