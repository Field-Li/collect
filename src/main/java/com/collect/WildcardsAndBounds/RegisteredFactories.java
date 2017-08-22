package com.collect.WildcardsAndBounds;

/**
 * Created by lifana on 2017/7/17.
 */
public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}