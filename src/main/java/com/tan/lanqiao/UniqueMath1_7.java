package com.tan.lanqiao;

/**
 * 用二进制表示一个小数
 * Created by Administrator on 2020/8/25.
 */
public class UniqueMath1_7 {
    public static void main(String[] args) {

        double n = 0.625;
        StringBuilder sb = new StringBuilder("0.");
        while (n > 0) {
            double temp = n * 2;
            if (temp >= 1) {
                sb.append("1");
                n = temp - 1;
            } else {
                sb.append("0");
                n = temp;
            }

            if (sb.length() > 43) {
                System.out.println("ERROR");
                return;
            }
        }

        System.out.println(sb.toString());

    }
}
