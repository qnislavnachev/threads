package com.clouway.task5;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class TTLThread extends Thread {

  private Integer current = 0;
  private Integer ttl;
  private String value;
  private boolean fieldLives = true;

  /**
   * A thread that will hold values in the Map.
   * @param ttl Time To Live for each thread.
   * @param value The String value it is holding.
   */
  public TTLThread(Integer ttl, String value) {
    this.ttl = ttl;
    this.value = value;
  }

  /**
   * Returns the String value of the thread.
   * @return
   */
  public  String getValue() {
    current = 0;
    return value;
  }

  /**
   * A setter for the value.
   * @param value the new value of the thread.
   */
  public synchronized void setValue(String value) {
    current = 0;
    this.value = value;
  }

  /**
   * Status of the thread.
   * @return Tru if it is alive, false if it is not.
   */
  public synchronized boolean threadIsAlive() {
    return fieldLives;
  }

  @Override
  public String toString() {
    return " value='" + value;
  }

  @Override
  public void run() {
    while (current <= ttl) {
      try {
        Thread.sleep(1000);
        current++;
      } catch (InterruptedException e) {
      }
    }
    System.out.println(Thread.currentThread().getName()+"  DIED");
    fieldLives=false;
  }
}
