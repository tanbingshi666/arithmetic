package com.tan.lanqiao;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class Recursion1_6_shell_sort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 0, 6, 5, 4, 3, 2, 1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 希尔排序是直接插入排序的一种高效排序算法，但是他不稳定
     * 核心思路：利用增量
     * 【9,8,7,6,5,4,3,2,1】 len=9
     * len/2 = 4 按照间隔为4的值划分为一个增量组 每一个增量组进行插入排序
     * 4 /2 =2 同上
     * 2/2=1 同上
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {

        //计算出增量次数
        for (int interal = arr.length / 2; interal > 0; interal = interal / 2) {
            for (int i = interal; i < arr.length; i++) {
                //进行增量组插入
                int insert = arr[i];
                int index = i - interal;
                // 大于-1保存能到达下标为0的值
                while (index > -1 && insert < arr[index]) {
                    arr[(index + interal)] = arr[index];
                    index -= interal;
                }
                arr[(index + interal)] = insert;
            }
        }
    }

}
