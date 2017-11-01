package com.collect.classLoader;

public class Test {
    private static String common;

    public Test(String common) {
        this.common = common;
    }

    public Test() {
        System.out.println("testing");
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }
}
