package task4;

public class Demo {
    public static void main(String[] args) {
        MyList list = new MyList(5);
        AddingThread add = new AddingThread(list);
        RemovingThread remove = new RemovingThread(list);
        add.start();
        remove.start();
    }
}