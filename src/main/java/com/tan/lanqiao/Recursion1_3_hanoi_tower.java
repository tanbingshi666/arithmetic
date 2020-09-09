package com.tan.lanqiao;

import java.util.Arrays;

/**
 * 使用递归解决汉诺塔问题 A 中1 - N 移动到B C作为辅助空间
 * 1 - N => A
 * 空    => B
 * 空    => C
 * <p>
 * 第一步: 把数据源A中的1 - N-1 移动 C(辅助)
 * 把数据源A中的N 移动到 B  此时A、B、C的角色发生变化 A(辅助) B(target) C(数据源)
 * 第二步：把数据源C中的1 - N-1 移动到B   A作为辅助空间
 * 如此递归
 */
public class Recursion1_3_hanoi_tower {

    public static void main(String[] args) {
        hanoiTower(3, "A", "B", "C");
    }

    public static void hanoiTower(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move\t" + N + "\tfrom\t" + from + "\tto\t" + to);
        } else {
            hanoiTower(N - 1, from, to, help);
            System.out.println("move\t" + (N - 1) + "\tfrom\t" + from + "\tto\t" + to);
            hanoiTower(N - 1, help, to, from);
        }

    }

}
