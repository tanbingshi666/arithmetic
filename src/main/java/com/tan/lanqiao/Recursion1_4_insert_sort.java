package com.tan.lanqiao;

import java.util.Arrays;

/**
 * 使用递归实现插入排序
 * 对于 0-k个数进行排序
 * 等价于
 * 对 0 - k-1个数进行排序
 * 然后把k插入 0 - k-1中
 * Created by Administrator on 2020/8/26.
 */
public class Recursion1_4_insert_sort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2, 6,0};
        insertSort(arr, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr, int k) {
        // 第一个元素直接返回
        if (k == 0) {
            return;
        }

        insertSort(arr, k - 1);
        // 保存k位值
        int k_value = arr[k];
        //记录k-1的下标
        int index = k - 1;
        // 移动比k_value大的数字
        while (index > -1 && arr[index] > k_value) {
            //大于k_value往后移
            arr[(index + 1)] = arr[index];
            // 下标递减
            index--;
        }
        //把k_value插入到对应的位置中
        arr[index + 1] = k_value;
    }

}
