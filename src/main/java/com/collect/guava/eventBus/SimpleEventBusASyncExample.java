package com.collect.guava.eventBus;

import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/*gauva eventBus 异步处理*/
public class SimpleEventBusASyncExample {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);
        AsyncEventBus asyncEventBus = new AsyncEventBus("asyncEventBus", executor);
        asyncEventBus.register(new SimpleListener());
        /**
         * 注册事件处理器
         */
        /*asyncEventBus.register(new Object(){
            @Subscribe
            public void handleUserInfoChangeEvent(SimpleListener userInfoChangeEvent){
                System.out.println("处理用户信息变化事件：" + userInfoChangeEvent.getClass().getName());
            }

            @Subscribe
            public void handleUserInfoChangeEvent(String test){
                System.out.println("deadEvent事件：" + test);
            }

            @Subscribe
            public void onEvent(DeadEvent de) {
                System.out.println("发布了错误的事件:" + de.getEvent());
            }

        });*/

        //或者
        asyncEventBus.post("lfian");
        asyncEventBus.post(13333);
        System.out.println("异步EventBus");
    }
}
