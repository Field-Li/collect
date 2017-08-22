package com.collect.logger;

/**
 * Created by lifana on 2017/7/24.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class MyApp1 {
    final static Logger logger = LoggerFactory.getLogger(MyApp1.class);

    public static void main(String[] args) {
        logger.info("Entering application.");

        Foo foo = new Foo();
        foo.doIt();
        logger.info("Exiting application.");

        TreeMap map = new TreeMap();
        map.put("s", "s");
        map.put("tt", "uts");

        LinkedHashMap link = new LinkedHashMap();
        link.put("sss", "ddd");

        LinkedList linkedList = new LinkedList<String>();
        linkedList.add("sss");
    }
}