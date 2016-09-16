package task5;

import java.util.Hashtable;
import java.util.Set;

public class TimeoutTable {
    private Hashtable<String, Integer> table;

    public TimeoutTable() {
        table = new Hashtable<>();
    }

    public void put(String key, Integer value) {
        table.put(key, value);
    }

    public Integer get(String key) {
        return table.get(key);
    }

    public void resetValue(String key) {
        table.put(key, 0);
    }

    public Set<String> keyList() {
        return table.keySet();
    }
}