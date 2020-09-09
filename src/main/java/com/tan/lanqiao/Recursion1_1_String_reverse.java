package com.tan.lanqiao;

/**
 * 使用递归实现一个字符串的翻转
 * Created by Administrator on 2020/8/26.
 */
public class Recursion1_1_String_reverse {

    public static void main(String[] args) {
        String reverse = reverse("abcd", 3);
        System.out.println(reverse);
    }

    /**
     * "abcd" =>
     * d + abc
     * d+c+ab
     * d+c+b+a
     * 找重复
     * 找变化
     * 找出口
     *
     * @param src
     */
    public static String reverse(String src, int index) {
        if (index == 0) {
            return "" + src.charAt(index);
        }
        return src.charAt(index) + reverse(src, index - 1);
    }

}
