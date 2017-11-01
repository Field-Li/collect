package com.collect.current.futureTask;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lifana on 2017/7/25.
 */

/**
 * HashMap不是线程安全的，因此要确保两个线程不会同时访问HashMap，Memoizer1采用了一种保守的方法，即对整个方法进行同步。
 * 这种方法能确保线程安全性，但会带来一个明显的可伸缩问题：每次只有一个线程可以执行compute。
 * @param <A>
 * @param <V>
 */
public class Memoizer1<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}