package com.clouway.task3;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class SynchronizedIncrement {

  public synchronized int increment(Integer number){
    Integer current = ++number;
    return current;
  }

}
