package com.clouway.threads.task5;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Author Martin Milev
 * @Date 07.07.16.
 */
public class TimeoutHashtable<K, V> {
  private Hashtable hashtable = new Hashtable<>();
  private Map<K, Integer> delays = new HashMap<K, Integer>();
  private final int life;
  private int called;

  public TimeoutHashtable(int life) {
    this.life = life;
  }

  public void put(K key, V value) {
    hashtable.put(key, value);
    delays.put(key, called);
    initThread(key);
  }

  public <T> T get(K key) {
    if (hashtable.contains(key)) {
      called = delays.get(key);
      delays.replace(key, called + 1);
      called = 0;
      return (T) hashtable.get(key);
    }
    return null;
  }

  public void remove(K key) {
    hashtable.remove(key);
  }

  private void initThread(K key) {
    new Thread() {
      private int timer = life;
      private int timeLived = 0;

      @Override
      public void run() {
        while (timer != 0) {
          try {
            sleep(1000l);
            timer--;
            timeLived++;
            if (delays.get(key) != 0) {
              timer += life * delays.get(key);
              delays.replace(key, 0);
              System.out.println(Thread.currentThread().getName() + " increase life.");
            }
          } catch (InterruptedException e) {
          }
        }
        System.out.println(Thread.currentThread().getName() + " removed " + key.toString() + " after " + timeLived);
        remove(key);
      }
    }.start();
  }
}
