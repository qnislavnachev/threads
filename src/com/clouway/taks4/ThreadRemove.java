package com.clouway.taks4;

import java.util.Random;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class ThreadRemove extends Thread {
  private SynchronizedList list;
  private Integer sleep;

  public ThreadRemove(SynchronizedList list, Integer sleep) {
    this.list = list;
    this.sleep=sleep;
  }

  public void run() {
    while (true){
      try {
        Thread.sleep(sleep);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      list.remove();
    }
  }
}
