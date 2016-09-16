package task5;

public class demo {
    public static void main(String[] args) {
        ObjectTable table = new ObjectTable();
        TimeoutThread thread = new TimeoutThread(table, 10);
        thread.start();
        table.put("Lemons", 10);
        table.put("Oranges", 5);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        table.get("Oranges");
    }
}