package com.clouway.threads.task4;

/**
 * Created by clouway on 15.04.16.
 */
public class Demo {
  public static void main(String[] args) throws InterruptedException {
    ObjectsList list = new ObjectsList(4);
    Object[] objectsToAdd = {"a", 12, 2, "sda", 53, 123, "42","a", 12, 2, "sda", 53, 123, "42","a", 12, 2, "sda", 53, 123, "42"};
    Thread threadAdd = new Thread(new ObjectProducer(list, objectsToAdd));
    Thread threadRemove = new Thread(new ObjectConsumer(list, 4));
    threadAdd.start();
    threadRemove.start();
  }
}
