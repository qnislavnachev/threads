package task4;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    public final List<Integer> newList;
    public final int maxSize;
    private int index = -1;

    public MyList(int maxSize) {
        this.maxSize = maxSize;
        newList = new ArrayList<Integer>(maxSize);
    }

    public synchronized void insert(int number) {
        if (maxSize == newList.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("It was interrupted");
            }
        }
        System.out.println("New item added.");
        newList.add(number);
        index++;
        notify();
    }

    public synchronized void remove() {
        if (newList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("It was interrupted.");
            }
        }
        System.out.println("Last item is removed!");
        newList.remove(index);
        index--;
        notify();
    }
}
