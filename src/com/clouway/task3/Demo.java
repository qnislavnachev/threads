package com.clouway.task3;


/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    SynchronyzedThread counter = new SynchronyzedThread(1, 10);
    Thread firstThread = new Thread(counter);
    Thread secondThread = new Thread(counter);
    counter.informThread(secondThread);
    counter.informThread(secondThread);
    firstThread.start();
    secondThread.start();
  }
}
