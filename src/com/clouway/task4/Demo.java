package com.clouway.task4;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Demo {
  public static void main(String[] args) {
    SynchronizedList synchronizedList = new SynchronizedList(10);
    ThreadAdd add = new ThreadAdd(synchronizedList, 500);
    ThreadRemove remove = new ThreadRemove(synchronizedList, 1000);

    add.start();
    remove.start();
  }
}
