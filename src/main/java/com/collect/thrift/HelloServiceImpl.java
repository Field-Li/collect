package com.collect.thrift;//package com.controller.thrift;
//
///**
// * Created by lifana on 2017/8/1.
// */
//import org.apache.thrift.TException;
//public class HelloServiceImpl implements Hello.Iface {
//    @Override
//    public boolean helloBoolean(boolean para) throws TException {
//        return para;
//    }
//    @Override
//    public int helloInt(int para) throws TException {
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return para;
//    }
//    @Override
//    public String helloNull() throws TException {
//        return null;
//    }
//    @Override
//    public String helloString(String para) throws TException {
//        return para;
//    }
//    @Override
//    public void helloVoid() throws TException {
//        System.out.println("Hello World");
//    }
//}