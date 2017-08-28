package com.collect.logger;

import java.util.ArrayList;
import java.util.List;

public class Foo2  extends  Foo implements InterTest{
    public static void main(String[] args) {
        System.out.println(Foo2.a);
        System.out.println(new Foo2());
    }

    @Override
    public void setting() {
        List list = new ArrayList<>();
    }
}
