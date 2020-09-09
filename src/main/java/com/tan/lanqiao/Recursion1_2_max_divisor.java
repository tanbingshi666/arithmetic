package com.tan.lanqiao;

/**
 * 使用递归求两个数的最大约数
 * Created by Administrator on 2020/8/26.
 */
public class Recursion1_2_max_divisor {

    public static void main(String[] args) {

    }

    /**
     * 10 5 => 10 % 5 ==0  --->5
     * 24 18   24 %18=6   18 % 6 == 0 --->6
     *
     * @param m
     * @param n
     */
    public static int divisor(int m, int n) {
        if (m % n == 0) {
            return n;
        }

        return divisor(n, m % n);
    }

}
