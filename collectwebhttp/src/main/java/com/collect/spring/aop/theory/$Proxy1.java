package com.collect.spring.aop.theory;
import java.lang.reflect.Method;
public class $Proxy1 implements UserMgr {
    public $Proxy1(InvocationHandler h) {
        this.h = h;
    }
    InvocationHandler h;
    @Override
    public  void addUser() {
        try {
        Method md = UserMgr.class.getMethod("addUser");
        h.invoke(this, md);
        }catch(Exception e) {e.printStackTrace();}
    }
    @Override
    public  void delUser() {
        try {
        Method md = UserMgr.class.getMethod("delUser");
        h.invoke(this, md);
        }catch(Exception e) {e.printStackTrace();}
    }

}