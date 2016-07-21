package com.clouway.task3;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public final class    SynchronyzedThread implements Runnable {
  private Integer from;
  private Integer to;
  private Integer sleepTime;
  private SynchronizedIncrement synchronizedIncrement;
  private Thread otherThread;

  public SynchronyzedThread(Integer from, Integer to, Integer sleepTime, SynchronizedIncrement synchronizedIncrement) {
    this.from = from;
    this.to = to;
    this.sleepTime = sleepTime;
    this.synchronizedIncrement = synchronizedIncrement;
  }

  public void informThread(Thread otherThread) {
    this.otherThread = otherThread;
  }

  @Override
  public void run() {
    while (from <= to) {
      try {
        System.out.println(Thread.currentThread().getName().toString() + " " + from);
        from = synchronizedIncrement.increment(from);
        Thread.sleep(sleepTime);

      } catch (InterruptedException e) {
        e.printStackTrace();
        return;
      }

    }
    otherThread.interrupt();
  }
}
