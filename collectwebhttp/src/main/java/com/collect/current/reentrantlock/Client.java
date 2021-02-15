package com.collect.current.reentrantlock;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/5/3
 * Time: 17:49
 */
public class Client {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("2", "3");
        final ObjTest o1 = new ObjTest();
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("i am thread1");
                o1.valString();
                System.out.println("i am thread1");
            }
        });
        thread1.start();

        final ObjTest o2 = new ObjTest();
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("i am thread2");
                o2.valString();
                System.out.println("i am thread2");
            }
        });
        thread2.start();
        System.out.println("123");
    }
}
