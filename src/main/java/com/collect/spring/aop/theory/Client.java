package com.collect.spring.aop.theory;

/**
 * JDK动态代理原理：用反射重新构造一个新的实现类（与另一个实现类有相同的功能），用该代理类去调用方法。
 * 参考链接：http://wiki.jikexueyuan.com/project/ssh-noob-learning/dynamic-proxy.html
 */
public class Client {
    public static void main(String[] args) throws Exception {
        UserMgr mgr = new UserMgrImpl();

        //为用户管理添加事务处理
        InvocationHandler h = new TransactionHandler(mgr);
        UserMgr u = (UserMgr)Proxy.newProxyInstance(UserMgr.class,h);

        //为用户管理添加显示方法执行时间的功能
//        TimeHandler h2 = new TimeHandler(u);
//        u = (UserMgr)Proxy.newProxyInstance(UserMgr.class,h2);

        u.addUser();
        System.out.println("\r\n==========华丽的分割线==========\r\n");
        u.delUser();
    }
}