package com.clouway.task3;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public final class SynchronyzedThread implements Runnable {
  private Integer from;
  private Integer to;

  public SynchronyzedThread(Integer from, Integer to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public void run() {
    synchronized (this) {
      for (int i = from; i <= to; i++) {
        System.out.println(Thread.currentThread().getName().toString() + " " + i);
        System.out.println();
        try {
          Thread.sleep(1000);
          notifyAll();
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      notifyAll();
    }
  }
}
