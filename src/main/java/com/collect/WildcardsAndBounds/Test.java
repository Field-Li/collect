package com.collect.WildcardsAndBounds;

import java.util.Date;

/**
 * Created by lifana on 2017/7/17.
 */
public class Test {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        Pair<String, String> ll = new Pair<String, String>("ss", "ss");
        boolean same = Util.compare(p1, p2);
        System.out.println(same);

        Date[] anArray = {new Date(1490282622755L), new Date(1490282622755L)};
//        List<Date> list = Lists.newArrayList(new Date(), new Date(145263525685L));
        System.out.println(Util.countGreaterThan(anArray, new Date(255222222222L)));

        Node node = new Node("Sss");
        node.setData(11);

        Node2 node2 = new Node2("ss");
        node2.setData("sss");




    }
}
