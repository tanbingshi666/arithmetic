package com.tan.arithmetic;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/9/6.
 */
public class Main01 {
    static int[] helper;

    public static void main(String[] args) {
//        int[] arr = {2, 1, 2, 3, 2, 2, 4};
//        int res = method(arr);
//        System.out.println(res);

        int[] arr = {2, 3, 5, 6, 9, 4, 7, 8, 10};
        helper = new int[arr.length];
//        int res = method2(arr, 0, arr.length - 1);

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    // 一个数超半
    public static int method(int[] arr) {

        // 一种：排序
//        Arrays.sort(arr);
//        return arr[arr.length / 2];

        // 第二种消除
        int temp = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == temp) {
                count++;
            } else if (arr[i] != temp) {
                count--;
            } else if (count == 0) {
                temp = arr[i];
            }
        }
        return temp;
    }

    //最小ID
    public static int method2(int[] arr, int left, int right) {
        //第一:排序
//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            if ((i + 1) != arr[i]) return i + 1;
//        }
//
//        return arr.length + 1;

        // 第二种:辅助空间
//        int[] temp = new int[arr.length + 1];
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > temp.length) continue;
//            temp[arr[i]] = 1;
//        }
//        //System.out.println(Arrays.toString(temp));
//
//        for (int i = 1; i < temp.length; i++) {
//            if (temp[i] == 0) return i + 1;
//        }
//
//        return arr.length + 1;

        // 第三种:分区法
        if (left > right) return arr.length + 1;

        int index = parition(arr, left, right);
        if (index + 1 == arr[index]) {
            //相等 在右边
            return method2(arr, index + 1, right);
        } else if (index + 1 < arr[index]) {
            return index + 1;
        } else {
            return method2(arr, left, index - 1);
        }

    }

    public static int parition(int[] arr, int left, int right) {
        int first = arr[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            while (l <= r && arr[l] <= first) l++;
            while (l <= r && arr[r] > first) r--;
            if (l < r) {
                // 交换左右值
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        //交换第一个值
        int temp = arr[r];
        arr[r] = first;
        arr[left] = temp;

        return r;

    }

    // 归并排序
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;// 分开左右

        int t = 0;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                helper[t] = arr[l];
                l++;
                t++;
            }

            if (arr[l] > arr[r]) {
                helper[t] = arr[r];
                t++;
                r++;
            }
        }

        while (l <= mid) {
            helper[t] = arr[l];
            t++;
            l++;
        }

        while (r <= right) {
            helper[t] = arr[r];
            t++;
            r++;
        }

        int index = 0;
        int ll = left;
        while (ll <= right) {
            arr[ll] = helper[index];
            ll++;
            index++;
        }

    }


}
