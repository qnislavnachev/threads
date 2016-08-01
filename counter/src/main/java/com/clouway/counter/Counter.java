package com.clouway.counter;

/**
 * Created by zumba on 01.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

class Counter implements Runnable {
    private final int max;
    private final long sleepTime;
    private int count;

    Counter(int max, long sleepTime) {
        this.max = max;
        this.sleepTime = sleepTime;
    }

    public void run() {
        System.out.println(increment());
    }

    /**
     * Increase count after 1000 milliseconds.
     *
     * @return Last counted number till reaching max or interrupted.
     */
    private String increment() {
        while (count < max) {
            try {
                Thread.sleep(sleepTime);
                count++;
            } catch (InterruptedException e) {
                break;
            }
        }
        return Thread.currentThread().getName() + " " + count;
    }
}
