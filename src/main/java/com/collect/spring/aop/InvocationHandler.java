package com.collect.spring.aop;

import java.lang.reflect.Method;

public interface InvocationHandler {
    public void invoke(Object o, Method m);
}