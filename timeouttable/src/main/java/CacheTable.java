import java.util.LinkedHashMap;

/**
 * Created by zumba on 11.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

class CacheTable<K, V> {
    private final LinkedHashMap container;

    CacheTable(LinkedHashMap container) {
        this.container = container;
    }

    LinkedHashMap getContainer() {
        return container;
    }

    /**
     * Puts element in Map
     *
     * @param element  that is putted in this Map.
     * @param lifeSpan life of the object that is put in this Map.
     */
    void put(K element, long lifeSpan) {
        LifeSpan lifeSpan1 = new LifeSpan(System.currentTimeMillis(), lifeSpan);
        container.put(element, lifeSpan1);
    }

    /**
     * Getting element and renew life span of element in the Map.
     *
     * @param element that is needed.
     * @return value of key.
     */
    V get(K element) {

        LifeSpan content = (LifeSpan) container.get(element);

        container.put(element, new LifeSpan(System.currentTimeMillis(), content.lifeSpan));

        return (V) container.get(element);
    }

    /**
     * Removes Key from map.
     *
     * @param element key for removing.
     * @return removed key.
     */
    public K remove(K element) {
        return (K) container.remove(element);
    }

}
