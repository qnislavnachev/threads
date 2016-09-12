package task4;

public class Demo {
    public static void main(String[] args) {
        MyList list = new MyList(5);
        AddingThread add = new AddingThread(list, 10);
        RemovingThread remove = new RemovingThread(list, 10);
        add.start();
        remove.start();
    }
}