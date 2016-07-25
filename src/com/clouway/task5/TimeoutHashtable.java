package com.clouway.task5;


import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class TimeoutHashtable {

  private Integer ttl;

  /**
   * A concurrent HashMap containing Integer Keys and TTLTHreads that live a given period of time.
   * @param ttl Time To Live for every Thread.
   */
  public TimeoutHashtable(Integer ttl) {
    this.ttl = ttl;
  }

  private ConcurrentHashMap<Integer, TTLThread> timeoutHashtable = new ConcurrentHashMap<>();

  /**
   * Puts a value in the Map, if the value does not exist makes a new thread with the value and starts it.
   * @param key A key for the value.
   * @param value A value as a string.
   */
  public synchronized void put(Integer key, String value) {
    if (timeoutHashtable.containsKey(key)) {
      timeoutHashtable.get(key).setValue(value);
    } else {
      TTLThread ttlThread = new TTLThread(ttl, value);
      timeoutHashtable.put(key, ttlThread);
      ttlThread.start();
    }
  }

  /**
   * Removes a thread from the Map.
   * @param key The key from the map.
   * @return Returns the key that is removed, or null if there is no such key in it.
   */
  public synchronized Integer remove(Integer key) {
    if (timeoutHashtable.containsKey(key)) {
      timeoutHashtable.remove(key);
      return key;
    }
    return null;
  }

  /**
   * Get a value from the map.
   * @param key The key behind which the value stands.
   * @return The string representation of the value, or null if there is no such key.
   */
  public synchronized String get(Integer key) {
    if (timeoutHashtable.containsKey(key)) {
      return timeoutHashtable.get(key).getValue();
    }
    return null;
  }

  /**
   * Get a thread object from the map.
   * @param key The key behind which the thread stands.
   * @return A TTLThread object.
   */
  public TTLThread getThread(Integer key) {
    return timeoutHashtable.get(key);
  }

  /**
   * The key set for the map. Required for the Killer Thread to iterate through the map.
   * @return A key set of the given map.
   */
  public Set<Integer> keySet() {
    return timeoutHashtable.keySet();
  }
}
