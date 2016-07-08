package com.clouway.threads.task2;


/**
 * Running two threads simultaneously.
 * When some of the threads finish counting, the other threads are interrupted.
 *
 * @Author Martin Milev
 * @Date 04.07.16.
 */
public class Demo {
  public static void main(String[] args) {
    Counter counter1 = new Counter(1, 10);
    Counter counter2 = new Counter(1, 5);
    Thread thread1 = new Thread(counter1);
    Thread thread2 = new Thread(counter2);
    counter1.control(thread2);
    counter2.control(thread1);
    thread1.start();
    thread2.start();
  }
}

class Counter implements Runnable {
  private final int min;
  private final int max;
  private Thread otherThread;

  public Counter(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public void control(Thread thread) {
    this.otherThread = thread;
  }

  @Override
  public void run() {
    try {
      for(int i = min; i <= max; i++){
        Thread.sleep(500L);
        System.out.println(Thread.currentThread().getName() + " " + i);
      }
      otherThread.interrupt();
    } catch (InterruptedException e) {
      System.out.println(Thread.currentThread().getName() + " finished counting.");
    }
  }
}