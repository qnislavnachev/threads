package com.clouway.threads.task4;

/**
 * @Author Martin Milev
 * @Date 05.07.16.
 */
public class ObjectProducer implements Runnable {
  private ObjectsList list;
  private Object[] objectsToAdd;

  public ObjectProducer(ObjectsList list, Object[] arr) {
    this.list = list;
    this.objectsToAdd = arr;
  }

  @Override
  public void run() {
    try {
      for (Object each : objectsToAdd) {
        Thread.sleep(500);
        list.add(each);
        System.out.println(Thread.currentThread().getName() + " added \"" + each.toString() + "\" to the list.");
      }
    } catch (InterruptedException e) {}
  }
}
