package com.collect.arith;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树，每层一个节点，求和最小
 */
public class DynamicArithmatic {
    private static Integer COLUMN = 5;
    private static Integer ROW = 5;
    int [][] maxSum;

    public static void main(String[] args) {
        int i, j, n = 6;
        int[][] num = {
                {7},
                {3,8},
                {8,1,0},
                {2,7,4,4},
                {4,5,2,6,5}
        };
        for(i = num.length - 2;i >= 0; i--){
            for(j = 0;j <=i;j++){
                num[i][j] += Math.min(num[i+1][j], num[i+1][j+1]);
//                System.out.println("num[" + i + "][" + j + "]=" + num[i][j]) ;
            }
        }
        System.out.println(num[0][0]);

    }
}
