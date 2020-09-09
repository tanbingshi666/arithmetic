package com.tan.leetcode;

/**
 * 爬楼梯
 * 给定一个正整数 n
 * 假设
 * 1 -> 1
 * 2 -> 2 [1,1] [2]
 * 3 -> 3 [1,1,1] [1,2] [2,1]
 * 4 -> 5 [1,1,1,1] [2,2] [1,2,1] [2,1,1] [1,1,2]
 * 根据以上规律我们可以 前面的两个数加和等于第三数
 * <p>
 * Created by Administrator on 2020/8/20.
 */
public class ClimbingStairs {
    public static void main(String[] args) {

        int res = climbingStairs(5);
        System.out.println(res);

    }

    public static int climbingStairs(int n) {

        // 如果传入的是1
        if (n == 1) {
            return n;
        }

        // 定义一个数组保存临时数据
        int[] temp = new int[n + 1];
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i <= n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }

        return temp[n];
    }

}
