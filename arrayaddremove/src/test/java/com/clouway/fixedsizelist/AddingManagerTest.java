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
public class AddingManagerTest {

    @Test
    public void happyPath() {
        int counter = 0;
        FixedList fixedList = new FixedList(1);
        AddingManager addingMangerThread = new AddingManager(fixedList);
        String expected = "\nAdded Item to Array. " + addingMangerThread.getName() + "\n0\n";
        ByteArrayOutputStream systemOutString = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(systemOutString);
        PrintStream old = System.out;

        System.setOut(ps);
        addingMangerThread.start();
        while (counter < 1000000000l) {
            counter++;
        }
        System.out.flush();

        assertThat(systemOutString.toString(), is(equalTo(expected)));
        System.setOut(old);
    }

    @Test
    public void addToFullList() {
        int counter = 0;
        FixedList fixedList = new FixedList(0);
        AddingManager addingMangerThread = new AddingManager(fixedList);
        String expected = "\nAdded Item to Array. " + addingMangerThread.getName() + "\nWait removing thread because array is full.\n";
        ByteArrayOutputStream systemOutString = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(systemOutString);
        PrintStream old = System.out;

        System.setOut(ps);
        addingMangerThread.start();
        while (counter < 1000000000l) {
            counter++;
        }
        System.out.flush();

        assertThat(systemOutString.toString(), is(equalTo(expected)));
        System.setOut(old);
    }
}