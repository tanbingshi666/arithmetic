package com.tan.lanqiao;

/**
 * 使用递归进行二分查找
 */
public class Recursion1_5_mid_search {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 6, 7, 8};
        int res = midSearch(arr, 0, arr.length - 1, 7);
        System.out.println(res);
    }

    public static int midSearch(int[] arr, int low, int high, int tar) {
        if (low > high) {
            return -1;
        }

        //获取中间下标以及值
        int mid_index = (low + high) / 2;
        int mid_value = arr[mid_index];
        //向右递归
        if (tar > mid_value) {
            return midSearch(arr, mid_index + 1, high, tar);
        } else if (tar < mid_value) {
            return midSearch(arr, 0, mid_index - 1, tar);
        } else {
            System.out.println("index:"+mid_index);
            return tar;
        }

    }

}
