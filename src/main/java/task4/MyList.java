package task4;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    public final List<Integer> newList;
    public final int maxSize;

    public MyList(int maxSize) {
        this.maxSize = maxSize;
        newList = new ArrayList<Integer>(maxSize);
    }

    public synchronized void insert(int number) {
        while (maxSize == newList.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("It was interrupted");
            }
        }
        System.out.println("New item added.");
        newList.add(number);
        notify();
    }

    public synchronized void remove() {
        while (newList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("It was interrupted.");
            }
        }
        System.out.println("Last item is removed!");
        newList.remove(newList.size() - 1);
        notify();
    }
}
