package com.tan.lanqiao;

/**
 * Created by Administrator on 2020/8/26.
 */
public class Recursion_Test_01 {
    public static void main(String[] args) {
        String res = kthGrammar(4, 5, "0");
        System.out.println(res);
    }

    public static String kthGrammar(int n, int k, String s) {

        if (n == 1) {
            System.out.println(s);
            return "" + s.charAt(k - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }

        return kthGrammar(n - 1, k, sb.toString());
    }
}
