package com.collect.thrift.test;


import org.apache.thrift.TException;

public class HelloWorldImpl implements HelloWorldService.Iface {

    public HelloWorldImpl() {
    }

    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome to my blog www.micmiu.com";
    }

}