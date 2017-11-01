package com.collect.arith;

public  class Test {
    /**
     * @param args add by zxx ,Dec 9, 2008
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(new Test().test());
        System.out.println("test");
    }
    static int test()
    {
        int x = 1;
        try
        {
            return x;
        }
        finally
        {
            ++x;
        }
    }
}