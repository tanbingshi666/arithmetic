package com.tan.lanqiao;

/**
 * 给定一个正整数的二进制n 将n的奇偶位互换
 * Created by Administrator on 2020/8/25.
 */
public class UniqueMath1_6 {
    public static void main(String[] args) {
        int n = 9; // 1001

        //计算奇位 偶位
        int a = n & 0xaaaaaaaa; // 0xaaaaaaaa = 1010 1010 1010 1010 1010 1010 1010 1010
        int b = n & 0x55555555; // 0x55555555 = 0101 0101 0101 0101 0101 0101 0101 0101

        int res = a >> 1 ^ b << 1;
        System.out.println(res);
    }
}
