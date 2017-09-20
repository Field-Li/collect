package com.collect.io;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteratorTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");

        //Exception in thread "main" java.util.ConcurrentModificationException
//        for (String key : map.keySet())
//            if (key.equals("c"))
//                map.remove(key);

        //Exception in thread "main" java.util.ConcurrentModificationException
//        for (Map.Entry<String, String> entry : map.entrySet())
//            if (entry.getKey().equals("c"))
//                map.remove(entry.getKey());

        //ok
        for(Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> entry = it.next();
            if(entry.getKey().equals("c")) {
                it.remove();
            }
        }
        System.out.println(map);

    }
}
