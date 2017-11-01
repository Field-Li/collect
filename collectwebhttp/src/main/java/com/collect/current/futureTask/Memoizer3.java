package com.collect.current.futureTask;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by lifana on 2017/7/25.
 */

/**
 * 我们可以在map中存放Future对象而不是最终计算结果，Future对象相当于一个占位符，它告诉用户，结果正在计算中，如果想得到最终结果，请调用get()方法。
 * Future的get()方法是一个阻塞方法，如果结果正在计算中，那么它会一直阻塞到结果计算完毕，然后返回；如果结果已经计算完毕，那么就直接返回.
 *
 * Memoizer3解决了上一个版本的问题，如果有其他线程在计算结果，那么新到的线程会一直等待这个结果被计算出来，
 * 但是他又一个缺陷，那就是仍然存在两个线程计算出相同值的漏洞。
 * 这是一个典型的"先检查再执行"引起的竞态条件错误，我们先检查map中是否存在结果，
 * 如果不存在，那就计算新值，这并不是一个原子操作，所以两个线程仍有可能在同一时间内调用compute来计算相同的值。
 * @param <A>
 * @param <V>
 */
public class Memoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                public V call() throws InterruptedException {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run(); // call to c.compute happens here
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            cache.remove(arg);
        }
        return null;
    }

    class MyTask implements Callable<String> {

        MyTask(String i){
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(100000000);
            System.out.println("我是线程："+Thread.currentThread().getName());
            return Thread.currentThread().getName();
        }
    }
    public static void main(String[] args) throws Exception{

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

        Memoizer3<Integer, String> memoizer = new Memoizer3<Integer, String>(c);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            FutureTask<String> future = new FutureTask<String>(memoizer.new MyTask(String.valueOf(i))) {
                // 异步任务执行完成，回调
                @Override
                protected void done() {
                    try {
                        System.out.println("future.done():" + get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(future);

            String result = future.get();
            System.out.println("future.get():" + result);
        }
        executorService.shutdown();
    }
}