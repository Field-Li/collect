package com.collect.guava.eventBus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;


/**
 * AllowConcurrentEvents 注解保证线程安全
 */
public class SimpleListener {
    @Subscribe
    @AllowConcurrentEvents
    public void task(String s) {
        System.out.println("我是字符串监听器：do task(" + s + ")");
    }

    @Subscribe
    public void intTask(Integer s) {
        System.out.println("我是整型监听器：do task(" + s + ")");
    }

    @Subscribe
    public void gotDeadEvent(DeadEvent deadEvent) {
        EventBus eventBus = (EventBus) deadEvent.getSource();
        System.out.println("Got dead event " + deadEvent.getEvent() + ", from " + eventBus);
    }
}
