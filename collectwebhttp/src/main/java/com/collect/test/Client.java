package com.collect.test;

import java.io.Serializable;

public class Client {
    public static void main(String[] args) {
        String abc = "123";
        String ddd = "123";
        System.out.println(abc == ddd);
        long number = 10L;
        new Client().getNum(number);
    }


    public void getNum(Serializable n){
        System.out.println(n);

    }
}
