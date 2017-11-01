package com.collect.current.futureTask;

/**
 * Created by lifana on 2017/7/25.
 */
interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;//耗时计算
}