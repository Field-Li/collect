package com.collect.io;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by lifana on 2017/8/14.
 */
public class StringBufferBuilder {
    public static void main(String[] args) {
        /*线程安全*/
        StringBuffer buffer = new StringBuffer();
        buffer.append("ss");

        /*不安全*/
        StringBuilder builder = new StringBuilder();
        builder.append("test");

        Hashtable table = new Hashtable();
        HashMap map = new HashMap();
        table.put("test", "testing");


    }
}
