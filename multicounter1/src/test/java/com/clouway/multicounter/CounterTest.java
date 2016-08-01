package com.clouway.multicounter;

import net.jodah.concurrentunit.Waiter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 18.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class CounterTest {

    @Test(timeout = 10000l)
    public void happyPath() throws InterruptedException {
        Counter counter = new Counter(2);
        Counter counter2 = new Counter(3);
        synchronized (Counter.class) {
            ThreadMonitor threadMonitor = new ThreadMonitor();

            counter.start();
            counter2.start();
            threadMonitor.kill(counter);
            threadMonitor.kill(counter2);
        }
    }
}