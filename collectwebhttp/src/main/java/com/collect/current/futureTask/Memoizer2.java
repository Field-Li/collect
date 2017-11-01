package com.collect.current.futureTask;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lifana on 2017/7/25.
 */

/**
 * 我们可以用ConcurrentHashMap代替HashMap来改进Memoizer1中糟糕的并发行为，由于ConcurrentHashMap是线程安全的，
 * 因此在访问底层Map时就不需要进行同步，因此避免了对compute()方法进行同步带来的串行性.
 * 但是这个版本的缓存还是有问题的，如果线程A启动了一个开销很大的计算，而其他线程并不知道这个线程正在进行，那么很可能会重复这个计算
 * @param <A>
 * @param <V>
 */
public class Memoizer2 <A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}