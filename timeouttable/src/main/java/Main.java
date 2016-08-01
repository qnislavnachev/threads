import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by zumba on 10.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class Main {
    public static void main(String[] args) {
        CacheTable cacheTable = new CacheTable(new LinkedHashMap());
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();
        Cleaner cleaner = new Cleaner(10000l, cacheTable);
        cacheTable.put(object, 60000l);
        cacheTable.put(object1, 10000l);
        cacheTable.put(object2, 10000l);
        cacheTable.get(object);
        cacheTable.get(object);
        cacheTable.get(object);
        System.out.println("Before cleaner thread starts" + cacheTable.getContainer());

        cleaner.start();
        BufferedReader br;
        while (true) {

            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                String input = br.readLine();
                if (input.equals("put")) {
                    cacheTable.put(new Object(), 1000l);
                }
                if (input.equals("get")) {
                    LifeSpan lifeSpan = (LifeSpan) cacheTable.get(object);
                    System.out.println("this is the life span of the longest living object " + object + lifeSpan.lifeSpan);
                }
                if (input.equals("exit")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}