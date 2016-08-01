package com.clouway.fixedsizelist;

import java.lang.*;

/**
 * Created by zumba on 08.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class FixedList {
    private final Object[] items;
    private int index = 0;

    public FixedList(int size) {
        this.items = new Object[size];
    }

    public Object[] getItems() {
        return items;
    }

    /**
     * Adding item in items array.
     *
     * @param item Object that is added
     * @throws ListFullException
     */
    public synchronized void add(Object item) throws ListFullException {

        if (index >= items.length) {
            throw new ListFullException("Can not add list if full");
        }
        items[index] = item;
        index++;
    }

    /**
     * Removes object from array.
     *
     * @throws ListEmptyException
     */
    public synchronized void remove() throws ListEmptyException {

        if (items[index - 1] == null) {
            throw new ListEmptyException("Can not remove list is empty");
        }
            items[index - 1] = null;
            index--;
    }

    /**
     * Prints all array as a string
     */
    public synchronized void printAllElements() {

        for (Object item : items) {
            System.out.println(item);
        }
    }

}