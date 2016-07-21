package com.clouway.task3;


/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    SynchronizedIncrement synchronizedIncrement = new SynchronizedIncrement();
    SynchronyzedThread counter1 = new SynchronyzedThread(1, 10,1000, synchronizedIncrement);
    SynchronyzedThread counter2 = new SynchronyzedThread(1, 3,500, synchronizedIncrement);

    Thread t1 = new Thread(counter1);
    Thread t2 = new Thread(counter2);

    counter1.informThread(t2);
    counter2.informThread(t1);

    t1.start();
    t2.start();
  }
}
