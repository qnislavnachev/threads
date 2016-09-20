package task5;

import java.util.*;

public class TimeoutTable<K, V> {
    private Hashtable<K, V> table = new Hashtable<>();
    private LinkedHashMap<K, Long> countingTable = new LinkedHashMap<>();
    private TimeoutThread<K, V> thread;
    private long timeout;

    public TimeoutTable(long timeout) {
        this.timeout =  timeout;
        thread = new TimeoutThread<>(table, countingTable, timeout);
        thread.start();
    }

    public synchronized void put(K key, V value) {
        if (table.containsKey(key)) {
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
}