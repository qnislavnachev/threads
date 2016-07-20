package com.clouway.task2;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public final class SynchronyzedThread implements Runnable {
  private Integer from;
  private Integer to;
  private Thread otherThread;

  public SynchronyzedThread(Integer from, Integer to) {
    this.from = from;
    this.to = to;
  }

  public void informThread(Thread otherThread) {
    this.otherThread = otherThread;
  }

  @Override
  public void run() {
    for (int i = from; i <= to; i++) {
      System.out.println(Thread.currentThread().getName().toString() + " " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName().toString() + "was interupted at value:");
        System.out.println(i);
        return;
      }
    }
    otherThread.interrupt();

  }
}

