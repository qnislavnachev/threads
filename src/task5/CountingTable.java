package task5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountingTable<K> {
    private Map<K, Integer> table;

    public CountingTable() {
        table = Collections.synchronizedMap(new HashMap<K, Integer>());
    }

    public void put(K key, Integer value) {
        table.put(key, value);
    }

    public Integer get(K key) {
        return table.get(key);
    }

    public void resetValue(K key) {
        table.put(key, 0);
    }

    public Set<K> keyList() {
        return table.keySet();
    }
}