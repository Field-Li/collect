package com.collect.io;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WeakHashMapTest {

    public static void main(String[] args) {
        WeakHashMap weak = new WeakHashMap();
        weak.put("ss", "ss");

        Set<String> set = new HashSet<String>();
        set.add("ssss");

        List<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        /*for(int i=0; i<list.size(); i++){
            list.remove(i);
        }*/
        for(int i=list.size()-1; i>=0; i--){
            list.remove(i);
        }
        for(String item:list){
            System.out.println(item);
        }

        Map map = new ConcurrentHashMap();
        map.put("ss", "ss");
    }
}
