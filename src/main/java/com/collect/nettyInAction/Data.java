package com.collect.nettyInAction;

/**
 * Created by lifana on 2017/6/8.
 */
public class Data {

    private int n;
    private int m;

    public Data(int n,int m){
        this.n = n;
        this.m = m;
    }

    @Override
    public String toString() {
        int r = n/m;
        return n + "/" + m +" = " + r;
    }
}
