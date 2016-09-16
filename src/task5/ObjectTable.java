package task5;

import java.util.Hashtable;
import java.util.Set;

public class ObjectTable {
    private Hashtable<String, Integer> table;
    private TimeoutTable timeoutTable;

    public ObjectTable() {
        table = new Hashtable<String, Integer>();
        timeoutTable = new TimeoutTable();
    }

    public void put(String key, Integer value) {
        if (table.containsKey(key)) {
            table.put(key, value);
            timeoutTable.resetValue(key);
            System.out.println("Item was used !");
        } else {
            table.put(key, value);
            timeoutTable.put(key, 0);
            System.out.println("New item added !");
        }
    }

    public Integer get(String key) {
        if(table.containsKey(key)) {
            timeoutTable.resetValue(key);
            return table.get(key);
        }
        return null;
    }

    public void remove(String key) {
        table.remove(key);
    }

    public Set<String> getTable() {
        return timeoutTable.keyList();
    }

    public TimeoutTable getTimeoutTable() {
        return timeoutTable;
    }
}
