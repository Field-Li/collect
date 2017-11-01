package com.collect.guava.eventBus;

import com.google.common.eventbus.EventBus;




/**
 * gauva eventBus 同步处理，一定要注意注册操作要放在spring启动时，多次注册会引起错误
 */
public class SimpleEventBusSyncExample {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new SimpleListener());
        System.out.println("Post Simple EventBus Example");
        eventBus.post("Simple EventBus Example");
        System.out.println("testing");
    }
}
