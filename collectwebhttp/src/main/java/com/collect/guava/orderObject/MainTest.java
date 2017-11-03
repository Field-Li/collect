package com.collect.guava.orderObject;

import com.google.common.base.Joiner;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lifana on 2017/5/26.
 */
public class MainTest {
    public static void main(String[] args) {
        Joiner join = Joiner.on(",").skipNulls();
        List<Foo> list = Lists.newArrayList(new Foo(1,2,3), new Foo(3, 5, 6));
        List<Foo> copyRouteMatrix = ImmutableList.copyOf(list);
        Collections.sort(list, new Comparator<Foo>() {
            @Override
            public int compare(Foo f1, Foo f2) {
                return ComparisonChain.start()
                        .compare(f2.a, f1.a)
                       .result();
//                return f2.a.compareTo(f1.a);
//                int resultA = f1.a - f2.a;
//                int resultB = f1.b - f2.b;
//                return resultA > 0 ? (resultB == 0 ? f1.c - f2.c : resultB) :resultA;
            }
        });

        int aa = copyRouteMatrix.indexOf(list.get(0));
        for(Foo foo : list){
            System.out.println(foo.a + "," + foo.b + "," + foo.c);
        }


        /*引入Guava比较链*/
        Collections.sort(list, new Comparator<Foo>(){
            @Override
            public int compare(Foo f1, Foo f2) {
                return ComparisonChain.start()
                   .compare(f2.a, f1.a)
                    .compare(f1.b, f2.b)
                    .compare(f1.c, f2.c).result();
        }});
        for(Foo foo : list){
            System.out.println(foo.a + "," + foo.b + "," + foo.c);
        }

        System.out.println("==================================================================================");

        /*引入Guava ordering*/
        Comparator<Foo> byA = new Comparator<Foo>() {
            @Override
            public int compare(Foo o1, Foo o2) {
                return o2.a.compareTo(o1.a);
            }
        };
        Comparator<Foo> byB = new Comparator<Foo>() {
            @Override
            public int compare(Foo o1, Foo o2) {
                return o2.b.compareTo(o1.b);
            }
        };
        Comparator<Foo> byC = new Comparator<Foo>() {
            @Override
            public int compare(Foo o1, Foo o2) {
                return o1.c.compareTo(o2.c);
            }
        };
        List conditions = Lists.newArrayList(byA, byB, byC);
        Ordering<Foo> ordering = Ordering.compound(conditions);
        Collections.sort(list, ordering);
        for(Foo foo : list){
            System.out.println(foo.a + "," + foo.b + "," + foo.c);
        }
    }
}