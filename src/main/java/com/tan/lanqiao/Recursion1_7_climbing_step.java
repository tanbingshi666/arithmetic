package com.tan.lanqiao;

/**
 * n阶楼梯
 * 每一步可以走1 或者2 或者3 一共有多少种走法
 * f(n) = f(n-1) + f(n-2) + f(n-3)
 */
public class Recursion1_7_climbing_step {

    public static void main(String[] args) {
        int res = climbingStep(3);
        System.out.println(res);

    }

    public static int climbingStep(int n) {

        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbingStep(n - 1) + climbingStep(n - 2) + climbingStep(n - 3);
    }

}
