package com.tan.lanqiao;

/**
 * 找出数组arr只出现一次的那一个数 其他数都是出现两次
 * Created by Administrator on 2020/8/25.
 */
public class UniqueMath1_3 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 6};
        int res = findOne(arr);
        System.out.println(res);

    }

    public static int findOne(int[] arr) {

        //临时变量
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            x ^= arr[i];
        }

        return x;

    }

}
