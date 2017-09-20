package com.collect.spring.aop.jdkDynamicProxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(
                userService);

        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();
    }
}