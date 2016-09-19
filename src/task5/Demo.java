package task5;

public class Demo {
    public static void main(String[] args) {
        TimeoutTable<String, Integer> table = new TimeoutTable<>(10);
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
