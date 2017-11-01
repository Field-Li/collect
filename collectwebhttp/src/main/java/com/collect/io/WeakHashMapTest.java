package com.collect.io;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WeakHashMapTest {

    public static void main(String[] args) {
        WeakHashMap weak = new WeakHashMap();
        weak.put("ss", "ss");

        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("lifan", 12, "男", "程序员");
        Person p2 = new Person("lifan", 12, "男", "程序员2");

        set.add(p1);
        set.add(p2);

        System.out.println(set);

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
