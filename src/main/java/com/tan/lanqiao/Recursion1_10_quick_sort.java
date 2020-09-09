package com.tan.lanqiao;

import java.util.Arrays;

public class Recursion1_10_quick_sort {

    public static void main(String[] args) {
        int[] arr = {15, 7, 10, 8, 16, 9, 10, 11};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {

        int l = left;
        int r = right;
        int mid = (left + right) / 2;
        int mid_value = arr[mid];

        while (l < r) {

            while (arr[l] < mid_value) {
                l += 1;
            }

            while (arr[r] > mid_value) {
                r -= 1;
            }

            if (l >= r) {
                break;
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == mid_value) {
                r -= 1;
            }

            if (arr[r] == mid_value) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        if (l < right) {
            quickSort(arr, l, right);
        }

    }

}
