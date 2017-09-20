package com.collect.spring.aop.jdkDynamicProxy;

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("----- add -----");
    }
}