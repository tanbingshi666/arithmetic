package com.tan.lanqiao;

/**
 * 给定一个正整数n 求n的二进制中1的个数
 * Created by Administrator on 2020/8/25.
 */
public class UniqueMath1_4 {
    public static void main(String[] args) {

        int n = 9;
        System.out.println(Integer.toString(n, 2));

        //方式一 : 比较 n 与 1<< 1  ==  1<<i
        int res = method_1(n);
        System.out.println(res);

        // 方式二: n向左移动i 与 1 == 1
        int res2 = method_2(n);
        System.out.println(res2);

        // 方式三: 减一 与自身 => 得出从右向左一的个数
        int res3 = method_3(n);
        System.out.println(res3);

    }

    public static int method_3(int n) {

        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }

        return count;
    }

    public static int method_2(int n) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((n >> i & 1) == 1) {
                count++;
            }
        }


        return count;

    }

    /**
     * 移动n 跟1相与运算
     *
     * @param n
     */
    public static int method_1(int n) {
        // 遍历
        int count = 0;
        for (int i = 0; i < n; i++) {
            // 当n 与 1向左移动i 如果跟1向左移动i 相等说明该为是1
            if ((n & (1 << i)) == 1 << i)
                count++;
        }

        return count;

    }


}
