package com.clouway.fixedsizelist;

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
public class RemovingManagerTest {

    @Test
    public void happyPath() {
        long counter = 0;
        FixedList fixedList = new FixedList(1);
        AddingManager addingManager = new AddingManager(fixedList);
        RemovingManager removingManager = new RemovingManager(fixedList, addingManager);
        String expected = "\nRemoving item." + removingManager.getName() + "\nRemoved item from Array. Thread-1\nnull\n";
        ByteArrayOutputStream systemOutString = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(systemOutString);
        PrintStream old = System.out;
        fixedList.add(1);
        System.setOut(ps);
        removingManager.start();

        while (counter < 100000l) {
            counter++;
        }
        System.out.flush();

        assertThat(systemOutString.toString(), is(equalTo(expected)));

        System.setOut(old);
    }

    @Test
    public void tryRemovingFromEmptyFixedList() {
        long counter = 0;
        FixedList fixedList = new FixedList(1);
        AddingManager addingManager = new AddingManager(fixedList);
        RemovingManager removingManager = new RemovingManager(fixedList, addingManager);
        String expected = "\nRemoving item." + removingManager.getName() + "\nWaiting for other thread because array is empty.\n";
        ByteArrayOutputStream systemOutString = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(systemOutString);
        PrintStream old = System.out;
        System.setOut(ps);

        removingManager.start();

        while (counter < 100000l) {
            counter++;
        }
        System.out.flush();

        assertThat(systemOutString.toString(), is(equalTo(expected)));

        System.setOut(old);
    }
}