package com.clouway.task4;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class ThreadAdd extends Thread {
  private SynchronizedList list;
  private Integer sleep;


  public ThreadAdd(SynchronizedList list, Integer sleep) {
    this.list = list;
    this.sleep = sleep;
  }

  public void run() {
    while (true){
      try {
        Thread.sleep(sleep);
        list.add(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
