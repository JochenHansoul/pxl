package robbery;

import java.util.Collections;

public class KnapsackUtil {
    public static <T extends Comparable<T> & Item> void fill(Knapsack<T> sack, Inventory<T> inv) {
        Collections.sort(inv.getItems());
        for(T item : inv.getItems()){
            sack.add(item);
        }
    }
}