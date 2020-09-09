package com.tan.lanqiao;

/**
 * 给定一个数组找出最大达递增序列
 */
public class Recursion1_9_max_incre_length {

    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 5, 7, 3, 4, 6, 8, 0};
        maxIncreLength(arr);
    }

    public static void maxIncreLength(int[] arr) {

        int begin = 0;
        int end = 0;
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[end] <= arr[i]) {
                end = i;
            } else {
                if ((i - begin) >= len) {
                    len = i - begin;
                }
                begin = i;
                end = i;
            }
        }
        System.out.println(len);

    }
}
