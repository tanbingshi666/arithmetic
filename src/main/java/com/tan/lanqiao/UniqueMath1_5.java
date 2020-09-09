package com.tan.lanqiao;

/**
 * 用一条语句判断一个正整数是否是2的整次方
 * 也就是该整数的二进制是不是只有一个1
 * Created by Administrator on 2020/8/25.
 */
public class UniqueMath1_5 {
    public static void main(String[] args) {

        int n = 16;
        System.out.println(Integer.toString(n, 2));

        if (((n - 1) & n) == 0) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
