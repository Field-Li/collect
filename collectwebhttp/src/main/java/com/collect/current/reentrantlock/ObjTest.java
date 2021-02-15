package com.collect.current.reentrantlock;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/5/3
 * Time: 17:47
 */
public class ObjTest {

    public static synchronized void valString(){
        System.out.println("method1-s1");
        System.out.println("method1-s2");
    }


    public static synchronized void valString2(){
        System.out.println("method2-s1");
        System.out.println("method2-s2");
    }
}
