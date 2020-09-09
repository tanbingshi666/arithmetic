package com.tan.leetcode;

/**
 * Created by Administrator on 2020/8/18.
 */
public class TwoSum {
    public static void main(String[] args) {

        int[] data = {2, 9, 7, 15};
//        twoSum_for(data, 9);
        twoSum_recurive(data, 9, 0, 1);
    }

    // 递归
    public static void twoSum_recurive(int[] data, int sum, int i1, int i2) {
        if (i1 < data.length && i2 < data.length) {
            if (data[i1] + data[i2] == sum) {
                System.out.println("[" + i1 + "," + i2 + "]");
                return;
            } else if (i2 == data.length - 1) {
                twoSum_recurive(data, sum, i1 + 1, i1 + 2);
            } else {
                twoSum_recurive(data, sum, i1, i2 + 1);
            }
        } else {
            System.out.println("no");
        }

    }

    // for循环
    public static void twoSum_for(int[] data, int sum) {

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] + data[j] == sum) {
                    System.out.println("[" + i + "," + j + "]");
                    break;
                }
            }
        }

    }
}
