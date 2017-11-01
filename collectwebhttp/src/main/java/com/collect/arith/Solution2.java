package com.collect.arith;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<String,String>();
        hm.put("3","three");
        hm.put("1","one");
        hm.put("4","four");
        hm.put("2","two");
//        printMap(hm);
        Map<String, String> treeMap = new TreeMap<String, String>(hm);

//        printMap(treeMap);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
//                return 2;
            }
        };
        Map<Integer, String> treeMap2 = new TreeMap<Integer, String>(comparator);
        treeMap2.put(3,"three");
        treeMap2.put(1,"one");
        treeMap2.put(4,"four");
        treeMap2.put(2,"two");
        printMap(treeMap2);

    }//main

    public static void printMap(Map<Integer,String> map) {
        Set s = map.entrySet();
        Iterator it = s.iterator();
        while ( it.hasNext() ) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = String.valueOf(entry.getKey());
            String value = (String) entry.getValue();
            System.out.println(key + " => " + value);
        }//while
        System.out.println("========================");
    }//printMap

    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 0, max = 0;
        for(int temp : nums){
            if(temp > maxLength){
                maxLength += 1;
                max = temp;
            } else{
                break;
            }
        }
        return maxLength;
    }
}
