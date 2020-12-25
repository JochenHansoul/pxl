package zelf;

import java.util.HashMap;

public class TryingHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("tree", 3);
        System.out.println(hashMap.containsKey("two"));
        System.out.println(hashMap.get("two"));

    }
}
