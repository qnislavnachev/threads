package com.clouway.threads.task1;

import java.util.Scanner;

/**
 * Simple chronometer app.
 * It counts seconds past after execution and stops after escape symbol "x" is entered.
 *
 * @Author Martin Milev
 * @Date 04.07.16.
 */
public class Demo {
  public static void main(String[] args) {
    String escSymbol = "x";
    Scanner sc = new Scanner(System.in);
    Chronometer chronometer = new Chronometer();
    Thread t1 = new Thread(chronometer);
    t1.start();
    if (sc.next().equals(escSymbol)) {
      t1.interrupt();
    }
  }
}

class Chronometer implements Runnable {
  @Override
  public void run() {
    int timing = 0;
    while (true) {
      try {
        Thread.sleep(1000);
        timing++;
      } catch (InterruptedException e) {
        System.out.println(timing);
        break;
      }
    }
  }
}
