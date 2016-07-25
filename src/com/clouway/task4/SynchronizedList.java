package com.clouway.task4;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class SynchronizedList {
  private final Integer maxSize;

  public SynchronizedList(Integer maxSize) {
    this.maxSize = maxSize;
  }

  private List<Integer> list = new LinkedList<>();

  public synchronized void remove() {
    while (list.isEmpty()) {
      try {
        System.out.println("are we waiting remove size "+list.size());
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Thread removed a number");
    list.remove(0);
    notifyAll();
  }

  public synchronized void add(Integer number) {
    while (list.size() == maxSize) {
      try {
        System.out.println("are we waiting add size "+list.size());
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName() + " added an object from the list. ");
    list.add(number);
    notifyAll();
  }

}

