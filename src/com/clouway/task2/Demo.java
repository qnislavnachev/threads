package com.clouway.task2;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    SynchronyzedThread firstCounter = new SynchronyzedThread(1, 5);
    SynchronyzedThread secondCounter = new SynchronyzedThread(1, 10);
    Thread firstThread = new Thread(firstCounter);
    Thread secondThread = new Thread(secondCounter);
    firstCounter.informThread(secondThread);
    secondCounter.informThread(firstThread);
    firstThread.start();
    secondThread.start();
  }
}