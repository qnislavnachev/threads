package task5;

/**
 * Created by IaNiTyy on 16.9.2016 г..
 */
public class demo {
    public static void main(String[] args) {
        ObjectTable table = new ObjectTable();
        TimeoutThread thread = new TimeoutThread(table, 10);
        thread.start();
        table.put("Lemons", 10);
    }
}
