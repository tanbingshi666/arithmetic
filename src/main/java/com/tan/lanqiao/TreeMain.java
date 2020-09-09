package com.tan.lanqiao;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/9/7.
 */
public class TreeMain {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 5, 1, 7, 9, 0};
//        pre(arr, 0);
//        in(arr, 0);
//        befor(arr, 0);
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void pre(int[] arr, int i) {
        if (i >= arr.length) return;

        System.out.println(arr[i]); //根
        pre(arr, 2 * i + 1); //左
        pre(arr, 2 * i + 2); //右
    }

    public static void in(int[] arr, int i) {
        if (i >= arr.length) return;
        in(arr, 2 * i + 1);
        System.out.println(arr[i]);
        in(arr, 2 * i + 2);
    }

    public static void befor(int[] arr, int i) {
        if (i >= arr.length) return;
        befor(arr, 2 * i + 1);
        befor(arr, 2 * i + 2);
        System.out.println(arr[i]);
    }

    // 堆排序
    public static void heapSort(int[] arr, int n) {
        // 1 先堆化
        heap(arr, n);

        // 2 交换 0 与 最右边界值
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 3 继续堆化
            heapMin(arr, 0, i);
        }
    }

    public static void heap(int[] arr, int n) {
        // 1 找到父节点
        for (int i = n / 2 - 1; i >= 0; i--) {
            // 2 该节点下堆化
            heapMin(arr, i, n);
        }
    }

    public static void heapMin(int[] arr, int i, int n) {
        // 1 找到该节点的左右孩子
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 2 判断左孩子是否越界
        if (left >= n) return;
        //
        int min = left;

        if (right >= n) {
            min = left;
        } else {
            // 3 判断左右节点大小 取小的
            if (arr[right] < arr[left]) {
                min = right;
            }
        }

        // 4 判断该节点与左右节点大小决定是否交换数值
        if (arr[i] <= arr[min]) return;

        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;

        // 5 继续判断最小值是否小顶堆
        heapMin(arr, min, n);
    }

}
