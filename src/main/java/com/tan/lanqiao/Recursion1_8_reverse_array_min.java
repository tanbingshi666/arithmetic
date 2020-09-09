package com.tan.lanqiao;

/**
 * 把一共有序递增的数组旋转
 * eg:[1,2,3,4,5] -> [3,4,5,1,2]
 * 找出最小值
 * 思路:类型二分查找
 * 找出中间值mid
 * arr[begin]<=arr[mid] -> 左边有序
 * 否则右边有序
 * 最小值存在于无序那么边
 */
public class Recursion1_8_reverse_array_min {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        int res = reverseArrayMin(arr);
        System.out.println(res);
    }

    public static int reverseArrayMin(int[] arr) {

        int begin = 0;
        int end = arr.length - 1;
        //这种情况下arr数组是有序的
        if (arr[begin] <= arr[end]) {
            return arr[begin];
        }

        while (begin + 1 < end) {
            int mid = (begin + end) / 2;
            if (arr[begin] <= arr[mid]) { //左侧有序
                begin = mid;
            } else {
                end = mid;
            }
        }

        return arr[end];

    }

}
