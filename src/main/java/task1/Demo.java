package task1;

public class Demo {
    public static void main(String[] args) {
        Threads thread = new Threads();
        thread.start();
        thread.threadKiller(thread,"stop");
    }
}
