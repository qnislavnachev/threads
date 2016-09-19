package task5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TimeoutTable<K, V> {
    private Map<K, V> table = Collections.synchronizedMap(new HashMap<K, V>());
    private CountingTable<K> countingTable = new CountingTable<K>();
    private TimeoutThread<K, V> thread;
    private int timeout;

    public TimeoutTable(int timeout) {
        this.timeout = timeout;
        thread = new TimeoutThread<K, V>(table, countingTable, timeout);
        thread.start();
    }

    public void put(K key, V value) {
        if (table.containsKey(key)) {
            table.put(key, value);
            countingTable.resetValue(key);
            System.out.println("Item was used !");
        } else {
            table.put(key, value);
            countingTable.put(key, 0);
            System.out.println("New item added !");
        }
    }

    public V get(K key) {
        if (table.containsKey(key)) {
            countingTable.resetValue(key);
            System.out.println("Item was used !");
            return table.get(key);
        }
        return null;
    }

    public void remove(K key) {
        table.remove(key);
    }
}