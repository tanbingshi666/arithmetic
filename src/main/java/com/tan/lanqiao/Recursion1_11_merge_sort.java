package com.tan.lanqiao;

import java.util.Arrays;

public class Recursion1_11_merge_sort {

    public static void main(String[] args) {

        int[] arr = {4, 8, 1, 3, 6, 9, 10, 11};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int l = left;
        int m = mid + 1;
        int r = right;
        int index = 0;

        while (l < m && m <= r) {

            if (arr[l] <= arr[m]) { //左边小于等于右边
                temp[index] = arr[l];
                index += 1;
                l += 1;
            }

            if (arr[l] > arr[m]) {
                temp[index] = arr[m];
                index += 1;
                m += 1;
            }

        }

        while (l < m) {
            temp[index] = arr[l];
            l += 1;
            index += 1;
        }

        while (m <= right) {
            temp[index] = arr[m];
            index += 1;
            m += 1;
        }

        int index_2 = 0;
        int l_index = left;
        while (l_index < right) {
            arr[l_index] = temp[index_2];
            index_2 += 1;
            l_index += 1;
        }
    }

}
