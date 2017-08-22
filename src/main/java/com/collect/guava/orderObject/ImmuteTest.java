package com.collect.guava.orderObject;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lifana on 2017/6/15.
 */
public class ImmuteTest {
    public static void main(String[] args) {
        List<Foo> list = Lists.newArrayList(new Foo(1, 2, 3), new Foo(4, 5,6));
        List<Foo> copyRouteMatrix = ImmutableList.copyOf(list);

        Collections.sort(list, new Comparator<Foo>(){
            @Override
            public int compare(Foo f1, Foo f2) {
                return ComparisonChain.start()
                        .compare(f2.a, f1.a)
                        .compare(f1.b, f2.b)
                        .compare(f1.c, f2.c).result();
            }});
        for(Foo foo : list){
            System.out.println("list:" + foo.getA() + ", " + foo.getB() + ", " + foo.getC());
        }
        for(Foo foo : copyRouteMatrix){
            System.out.println("copyRouteMatrix:" + foo.getA() + ", " + foo.getB() + ", " + foo.getC());
        }
    }
}
