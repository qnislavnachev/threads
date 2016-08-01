package com.clouway.multithreadcounter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by clouway on 18.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class CounterTest {

  @Test
  public void happyPath() {
    long counter1 = 0;
    Thread listener = new Thread();
    Counter counter = new Counter(3, listener);
    Counter counter2 = new Counter(3, listener);
    String expected = counter.getName() + ": 1\n"+counter2.getName()+": 1\n"+counter.getName() + ": 2\n"+counter2.getName()+": 2\n"+counter.getName() + ": 3\n"+counter2.getName()+": 3\n"+ "Done! " +counter.getName() + "\nDone! " +counter2.getName()+"\n";
    ByteArrayOutputStream actual = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(actual);
    PrintStream old = System.out;

    System.setOut(ps);
    synchronized (Thread.class) {
      counter.start();
      counter2.start();
    }

    while (counter.isAlive()) {
      counter1++;
    }
    System.out.flush();

    assertThat(actual.toString(), is(equalTo(expected)));

    System.setOut(old);
  }
}