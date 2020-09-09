package com.tan.lanqiao;

import java.util.Arrays;

public class Recursion1_12_odd_event {

    public static void main(String[] args) {

        int[] arr = {1, 4, 3, 5, 3, 6, 7, 8, 2, 1};
        method(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void method(int[] arr, int left, int right) {

        int l = left;
        int r = right;
        int m = (left + right) / 2;

        while (l < r) {

            while (arr[l] % 2 != 0) { //左边找偶数
                l += 1;
            }

            while (arr[r] % 2 == 0) { //右边找奇数
                r -= 1;
            }

            if (l >= r) {
                break;
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (l == m) {
                r -= 1;
            }
            if (r == m) {
                l += 1;
            }

        }
//        if (l == r) {
//            l += 1;
//            r -= 1;
//        }
//
//        if (left < r) {
//            method(arr, left, r);
//        }
//        if (l < right) {
//            method(arr, l, right);
//        }
    }

    public static void method(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int m = (left + right) / 2;
            method(arr, left, m, temp);
            method(arr, m + 1, right, temp);
            merge(arr, left, m, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int l = left;
        int m = mid + 1;
        int r = left;
        int index_l = 0;
        int index_r = temp.length - 1;

        while (l < m) {
            if (arr[l] % 2 == 0) {
                temp[index_r] = arr[l];
                index_r -= 1;
            } else {
                temp[index_l] = arr[l];
                index_l += 1;
            }
            l += 1;
        }

        while (m <= r) {
            if (arr[m] % 2 == 0) {
                temp[index_r] = arr[m];
                index_r -= 1;
            } else {
                temp[index_l] = arr[m];
                index_l += 1;
            }
            m += 1;
        }


    }

}
