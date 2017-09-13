package com.collect.selfAnnotation;

import java.lang.reflect.Method;

public class TestableProcessor {

    public static void process(String clazz) throws ClassNotFoundException {
        int passed=0;
        int failed=0;
        for(Method m:Class.forName(clazz).getMethods()){
            //判断该方法是否运用了该注解
            if(m.isAnnotationPresent(Testable.class)){
                try {
                    m.invoke(null);
                    passed++;
                }catch (Exception e){
                    failed++;
                }
            }
        }
        System.out.println("run some methods"+(passed+failed)+" pass:"+passed+" fail: "+failed);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        process("com.collect.selfAnnotation.MyTestable");
    }
}