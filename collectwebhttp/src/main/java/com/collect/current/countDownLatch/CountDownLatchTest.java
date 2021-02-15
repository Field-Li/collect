package com.collect.current.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lifana on 2017/7/25.
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTest test = new CountDownLatchTest();
        test.timeTasks(5, test.new RunnableTask());
    }

    public void timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(800);
                        /*全部阻塞在这里，直到startGate.countDown()才执行*/
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            /*等每一个线程执行完才退出计算耗时，所以需要另外一个闭锁*/
                            endGate.countDown();
                        }
                    } catch (Exception ignored) {

                    }

                }
            };
            t.start();
        }

        long start = System.nanoTime();
        System.out.println("打开闭锁");
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println("闭锁退出，共耗时" + (end - start));
    }

    class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("当前线程为：" + Thread.currentThread().getName());

        }
    }
}