package com.clouway.threads.task3;

/**
 * Runs two threads synchronized.
 * Each one is waiting notification from the other.
 * @Author Martin Milev
 * @Date 04.07.16.
 */
public class Demo {
  public static void main(String[] args) {
    Counter counter = new Counter(5);

    Thread t1 = new Thread(counter);
    Thread t2 = new Thread(counter);

    t1.start();
    t2.start();
  }
}

class Counter implements Runnable {
  private final int max;

  public Counter(int max) {
    this.max = max;
  }

  @Override
  public void run() {
    synchronized (this) {
      for (int i = 1; i <= max; i++) {
        try {
          notifyAll();
          wait();
          Thread.sleep(500);
        } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + " " + i);
      }
      notifyAll();
    }
  }
}
