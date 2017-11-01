package com.collect.current.futureTask;

import com.google.common.base.Strings;

import java.util.concurrent.*;

/**
 * Created by lifana on 2017/7/25.
 */

/**
 * Memoizer3存在这个问题的原因是，复合操作"若没有则添加"不具有原子性，我们可以改用ConcurrentMap中的原子方法putIfAbsent，避免了Memoizer3的漏洞。
 *
 * 当缓存对象是Future而不是值的时候，将导致缓存污染问题，因为某个计算可能被取消或失败，当出现这种情况时，我们应该把对象从map中移除，然后再重新计算一遍。
 * 这个缓存系统的使用十分简单，只需传入一个Computable对象即可构造缓存，要得到计算结果，调用compute()方法即可，该方法会把计算过的结果缓存起来。
 * @param <A>
 * @param <V>
 */
public class Memoizer4 <A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, Future<V>> cache
            = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer4(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = new Callable<V>() {
                    public V call() throws InterruptedException {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(arg, f);
            } catch (ExecutionException e) {
//                throw LaunderThrowable.launderThrowable(e.getCause());
            }
        }
    }

    public static void main(String[] args) throws  Exception{


        String address = "111";
        String houseNumber = "";
        String temp = "";

        if(Strings.nullToEmpty(address).contains(Strings.nullToEmpty(houseNumber))){
            temp = (Strings.nullToEmpty(address));
        } else{
            temp = (Strings.nullToEmpty(address).concat(Strings.nullToEmpty(houseNumber)));
        }


        Computable<Integer, String> c = new Computable<Integer, String>() {

            @Override
            public String compute(Integer a) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String result = "由线程：" + Thread.currentThread().getName()
                        + "计算得到" + a + "的结果";
                return result;
            }
        };


        new Memoizer4<Integer, String>(c).compute(44);
    }
}