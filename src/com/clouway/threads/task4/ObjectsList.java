package com.clouway.threads.task4;

/**
 * Created by clouway on 15.04.16.
 */
public class ObjectsList {
  private Object[] list;
  private int it = 0;

  public ObjectsList(int size) {
    this.list = new Object[size];
  }

  /**
   * Creating the list.
   *
   * @param obj
   */
  public synchronized void add(Object obj) throws InterruptedException {
    if (it == list.length) {
      wait();
    } else {
      addNew(obj);
    }
  }

  /**
   * Removes the last element of the list.
   */
  public synchronized void remove() throws InterruptedException {
    if (list == null) {
      wait();
    }
    if (list[0] != null) {
      if (list[it - 1] != null) {
        list[it - 1] = null;
        it--;
      }
      notifyAll();
    } else {
      wait();
    }
  }

  /**
   * Printing the list.
   *
   * @return
   */
  public String toString() {
    String str = "";
    for (Object o : list) {
      str += o + " ";
    }
    return str;
  }

  /**
   * Adds elements to the end of the list.
   *
   * @param obj
   */
  private void addNew(Object obj) throws InterruptedException {
    list[it] = obj;
    it++;
    notifyAll();
  }
}
