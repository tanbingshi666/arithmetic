package com.tan.arithmetic;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/8/18.
 */
public class MergeSort {
    public static void main(String[] args) {
        int data[] = {8, 4, 5, 7, 1, 3, 6, 2,9};
        int[] temp = new int[data.length];
        mergeSort(data,0,data.length-1,temp);
        System.out.println(Arrays.toString(data));

    }

    public static void mergeSort(int[] data, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归
            mergeSort(data, left, mid, temp);
            //向右递归
            mergeSort(data, mid + 1, right, temp);
            //合并
           merge(data, left, mid, right, temp);
        }

    }

    /**
     * @param data  要排序的数据集合
     * @param left  要排序的数据集合的左边有序集合开始下标 开始值是0
     * @param mid   要排序的数据集合中间数据的下标
     * @param right 要排序的数据集合的右边有序集合开始下标 开始值是data.length - 1
     * @param temp  临时数组集合
     */
    public static void merge(int[] data, int left, int mid, int right, int[] temp) {

        int i = left; //左边有序集合的下标
        int j = mid + 1;//右边有序集合的下标
        int t = 0; // 临时数组集合的开始下标

        // 确保左边没有遍历过中间值或者右边超出索引
        while (i <= mid && j <= right) {

            // 左边的值小于右边的值
            if (data[i] <= data[j]) {
                temp[t] = data[i];
                i += 1;
                t += 1;
            }

            // 左边的值大于右边的值
            if (data[i] > data[j]) {
                temp[t] = data[j];
                j += 1;
                t += 1;
            }
        }

        // 上面的循环结束的添加是左边遍历到中间值或者右边的遍历到最大长度
        // 1 左边没有遍历完
        while (i <= mid) {
            temp[t] = data[i];
            i += 1;
            t += 1;
        }
        // 2 右边没有遍历完
        while (j <= right) {
            temp[t] = data[j];
            j += 1;
            t += 1;
        }

        // 复制(覆盖)
        t = 0;
        int lt = left;
        while (lt <= right) {
            data[lt] = temp[t];
            lt += 1;
            t += 1;
        }


    }
}
