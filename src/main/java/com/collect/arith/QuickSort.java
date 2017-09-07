package com.collect.arith;

public class QuickSort {

    public int[] array;
    private int low;
    private int high;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    //交换数组中两个元素的数据
    private void swap(int low,int high){
        int temp = array[high];
        array[high] = array[low];
        array[low] = temp;
    }

    private int partition(int low,int high,int pivot){
        while(low < high){
            while(low < high &&array[high]>=pivot){
                high--;
            }
            swap(low, high);
            while(low < high && array[low] <= pivot){
                low++;
            }
            swap(low, high);
        }
        return low;
    }

    private void handleQuickSort(int low, int high) {
        if (low >= high) {
            return;
        } else {
            int pivot = array[low];  //以第一个元素为基准
            int partition =partition(low,high,pivot);  //对数组进行划分，比pivot小的元素在低位段，比pivot大的元素在高位段

            handleQuickSort(low,partition-1);   //对划分后的低位段进行快速排序
            handleQuickSort(partition+1,high);  //对划分后的高位段进行快速排序
        }
    }

    /*{25,24,6,65,11,43,22,51}*/
    public void quikSort(){
        handleQuickSort(0, array.length - 1);
    }
}
