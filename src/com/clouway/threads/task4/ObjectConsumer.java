package com.clouway.threads.task4;

/**
 * @Author Martin Milev
 * @Date 05.07.16.
 */
public class ObjectConsumer implements Runnable {
  private ObjectsList list;
  private int objectsToRemove;

  public ObjectConsumer(ObjectsList list, int n) {
    this.list = list;
    objectsToRemove = n;
  }

  @Override
  public void run() {
    try{
      for(int i = 0; i <= objectsToRemove; i++) {
        Thread.sleep(5000);
        list.remove();
        System.out.println(Thread.currentThread().getName() + " removed the last object the list.");
      }
    } catch (InterruptedException e) {}
  }
}
