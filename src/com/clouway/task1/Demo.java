package com.clouway.task1;

import java.util.Scanner;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Demo {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String breaker = sc.next();
    Integer maxCount = sc.nextInt();
    Thread countingThread=new Thread(new CountingThread(maxCount));

      countingThread.start();
      if (sc.next().equals(breaker)) {
        countingThread.interrupt();
      }
    }
  }

