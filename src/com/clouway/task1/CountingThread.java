package com.clouway.task1;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public final class CountingThread implements Runnable {
  private Integer current = 0;
  private Integer maxCount;

  public CountingThread(Integer maxCount) {
    this.maxCount = maxCount;
  }

  @Override
  public void run() {
    while (current <= maxCount) {
      System.out.println(Thread.currentThread().getName().toString());
      System.out.println(current);
      try {
        Thread.sleep(1000);
        if (current == maxCount) {
          System.out.println(current);
          Thread.currentThread().interrupt();
        }
        current++;
      } catch (InterruptedException e) {
        System.out.println(current);
        return;
      }
    }
  }
}

