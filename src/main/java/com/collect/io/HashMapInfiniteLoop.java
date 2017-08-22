package com.collect.io;

import java.util.HashMap;

/**
 * Created by lifana on 2017/8/14.
 */
public class HashMapInfiniteLoop {

    private static HashMap<Integer, String> map = new HashMap<Integer, String>(2, 0.75f);

    public static void main(String[] args) throws Exception {
        map.put(5, "C");

        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                System.out.println(map);
                map.get(11);
            }

        }.start();

        Thread.sleep(1000);
        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            }
        }.start();
        Thread.sleep(5000);

        System.out.println("1 << 30:" + String.valueOf(1 << 30));

    }
}