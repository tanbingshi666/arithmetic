package com.tan.lanqiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2020/9/9.
 */
public class HeapTopK {
    static int[] heap;
    static int index = 0;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1 输入 k
        k = sc.nextInt();
        heap = new int[k];

        // 2 处理输入数据
        int x = sc.nextInt();
        while (x != -1) {
            deal(x);
            x = sc.nextInt();
        }

        System.out.println(Arrays.toString(heap));
    }

    public static void deal(int x) {
        if (index < k) {
            heap[index] = x;
            index++;
            if (index == k) {
                // 堆化
                heap(heap);
            }
        } else if (heap[0] < x) {
            heap[0] = x;
            heap(heap);
            System.out.println(Arrays.toString(heap));
        }
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        for (int i = k - 1; i >= 0; i--) {

        }
    }

    public static void heap(int[] arr) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapMin(arr, i);
        }
    }

    public static void heapMin(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 左孩子
        if (left >= k) {
            return;
        }

        int min = left;
        if (right >= k) {
            min = left;
        } else {
            if (arr[right] < arr[min]) {
                min = right;
            }
        }

        if (arr[i] < arr[min]) return;

        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;

        //向下递归
        heapMin(arr, min);
    }
}
