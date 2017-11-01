package com.collect.arith;//package com.collect.arith;

public class TestQuickSort {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] list={25,24,6,65,11,43,22,51};
        QuickSort qs=new QuickSort();
        System.out.println("快排前的数组是：");
        for(int i=0;i<list.length;i++){
            System.out.print(list[i]+" ");
        }
        qs.setArray(list);
        qs.quikSort();
        int[] list2= qs.getArray();
        System.out.println();
        System.out.println("快排后的数组是：");
        for(int i=0;i<list2.length;i++){
            System.out.print(list2[i]+" ");
        }
    }
}
