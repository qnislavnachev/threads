package com.clouway.task5;

import java.util.Set;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Killer extends Thread {
  private TimeoutHashtable timeoutHashtable;
  private Integer ttc;

  /**
   * A Killer Thread that iterates through the Map to check for dead values.
   * @param timeoutHashtable The Map it will iterate trough.
   * @param ttc Time To Check.
   */
  public Killer(TimeoutHashtable timeoutHashtable, Integer ttc) {
    this.timeoutHashtable = timeoutHashtable;
    this.ttc = ttc;
  }

  public void run() {
    while (true) {
      Set<Integer> tableKeySet = timeoutHashtable.keySet();
      for (Integer key : tableKeySet) {
        if (!timeoutHashtable.getThread(key).threadIsAlive()) {
          timeoutHashtable.getThread(key).interrupt();
          timeoutHashtable.remove(key);
          System.out.println(Thread.currentThread().getName()+" has removed a thread.");
        }
        try {
          Thread.sleep(ttc);
        } catch (InterruptedException e) {
        }
      }
    }
  }
}


