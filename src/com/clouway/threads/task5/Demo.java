package com.clouway.threads.task5;

/**
 * @Author Martin Milev
 * @Date 07.07.16.
 */
public class Demo {
  public static void main(String[] args) {
    TimeoutHashtable hashtable = new TimeoutHashtable(5);
    hashtable.put(1,1);
//    hashtable.put(2,2);
//    hashtable.put(3,3);
//    hashtable.put(4,4);

    hashtable.get(1);
//    hashtable.get(2);
//    hashtable.get(3);
  }
}
