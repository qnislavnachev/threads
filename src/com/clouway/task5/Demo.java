package com.clouway.task5;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Demo {
  public static void main(String[] args) throws InterruptedException {


    TimeoutHashtable timeoutHashtable=new TimeoutHashtable(4);
    Killer killer=new Killer(timeoutHashtable,4);
    killer.start();

    timeoutHashtable.put(1,"Marto");
    timeoutHashtable.put(2,"Vasko");
    timeoutHashtable.put(3,"Sasho");
    timeoutHashtable.put(4,"Qni");
    timeoutHashtable.put(5,"Denis");

    Thread.sleep(2000L);

    System.out.println(timeoutHashtable.get(2));
    System.out.println(timeoutHashtable.get(1));
    System.out.println(timeoutHashtable.get(4));
    System.out.println(timeoutHashtable.remove(1));
    timeoutHashtable.put(2,"Vasko Alone");
    System.out.println(timeoutHashtable.remove(1));
    System.out.println(timeoutHashtable.get(1));
    System.out.println(timeoutHashtable.get(2));

    Thread.sleep(4000L);
    System.out.println(timeoutHashtable.get(1));
  }
}
