package task1;

import java.util.Scanner;

public class Threads extends Thread {
    private int count = 0;
    private Scanner scanner;

    public Threads() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted at: " + count);
                return;
            }
            count++;
        }
    }

    /**
     * Kills thread when you enter a keyword
     * @param thread is a thread to kill
     * @param keyword is a  keyword to kill the thread
     */
    public void threadKiller(Threads thread, String keyword) {
        System.out.println("Enter '" + keyword + "' to kill thread:");
        while (true) {
            if (scanner.nextLine().equals(keyword)) {
                thread.interrupt();
                return;
            }
        }
    }
}