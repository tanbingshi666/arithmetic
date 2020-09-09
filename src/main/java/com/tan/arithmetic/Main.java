package com.tan.arithmetic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2020/9/3.
 */
public class Main {

    static int max = 0;

    public static void main(String[] args) {
//        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        method(arr, 0, arr.length - 1);
//        System.out.println(max);

//        String[] str = {"flower", "glow", "flight"};
//        method2(str);

//        int[] arr = {-1, 0, 1, 2, -1, -4};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        //method3(arr);
//        method4(arr, 0, arr.length - 1);

        // int[] arr = {7, 1, 5, 3, 6, 4};
//        int res = method5(arr);
//        System.out.println(res);
//        method6(arr);
//        int res = method7(arr);
//        System.out.println(res);

//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        method9(arr);
//        String s1 = "123";
//        String s2 = "456";
//        method10(s1, s2);

        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int res = method12(arr, 0, arr.length - 1, 3);
        System.out.println(res);
    }

    public static void method(int[] arr, int left, int right) {

        if (left >= right) return;

        int leftNum = arr[left];
        int rightNum = arr[right];
        int len = right - left;

        int maxArea = Math.min(leftNum, rightNum) * len;
        if (maxArea > max) {
            max = maxArea;
        }

        if (leftNum >= Math.min(leftNum, rightNum)) {
            method(arr, left + 1, right);
        } else if (rightNum == Math.min(leftNum, rightNum)) {
            method(arr, left, right - 1);
        }

    }

    public static void method2(String[] str) {
        String res = "";
        for (int i = 0; i < str[0].length(); i++) {
            String temp = "" + str[0].substring(0, i + 1);
            boolean flag = true;
            for (int j = 0; j < str.length; j++) {
                if (!str[j].startsWith(temp)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            } else {
                res = temp;
            }
        }
        System.out.println(res);
    }

    public static void method3(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println(arr[i] + "+" + arr[j] + "+" + arr[k]);
                    }
                }
            }
        }
    }

    public static void method4(int[] arr, int left, int right) {
        if (left > right) return;
        int value = 0 - (arr[left] + arr[right]);
        for (int i = left + 1; i < right; i++) {
            if (value == arr[i]) {
                System.out.println(arr[left] + "+" + arr[i] + "+" + arr[right]);
            }
        }

        method4(arr, left, right - 1);

        method4(arr, left + 1, right);

    }

    //暴力解决股票最大值
    public static int method5(int[] arr) {

        int maxPro = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] > maxPro) {
                    maxPro = arr[j] - arr[i];
                }
            }
        }
        return maxPro;
    }

    public static void method6(int[] arr) {
        int maxPro = 0;
        //维持一个最小值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if ((arr[i] - min) > maxPro) {
                maxPro = arr[i] - min;
            }
        }
        System.out.println(maxPro);
    }


    public static int method7(int[] arr) {
        int maxPro = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                maxPro += arr[i] - arr[i - 1];
            }
        }
        return maxPro;
    }

    public static int method8(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[arr.length][arr[0].length];
        int maxArea = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                maxArea = Math.max(dp[i][j], maxArea);
            }
        }

        return maxArea * maxArea;
    }


    public static void method9(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }
        System.out.println(Arrays.toString(dp));
    }

    public static void method10(String num1, String num2) {
        int len_1 = num1.length();
        int[] arr_1 = new int[len_1];
        for (int i = 0; i < arr_1.length; i++) {
            int pow = (int) Math.pow(10, arr_1.length - 1 - i);
            int value = num1.charAt(i) - 48;
            arr_1[i] = pow * value;

        }
        int len_2 = num2.length();
        int[] arr_2 = new int[len_2];
        for (int i = 0; i < arr_2.length; i++) {
            int pow = (int) Math.pow(10, arr_2.length - 1 - i);
            int value = num2.charAt(i) - 48;
            arr_2[i] = pow * value;

        }

        int sum = 0;
        for (int i = 0; i < arr_1.length; i++) {
            for (int j = 0; j < arr_2.length; j++) {
                sum += arr_1[i] * arr_2[j];
            }
        }
        System.out.println(sum);
    }

    public static int method11(int[][] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    max += dfs(arr, i, j);
                }
            }
        }
        return max;
    }

    public static int dfs(int[][] arr, int i, int j) {
        int num = 0;
        if (i >= 0 && i < arr[i].length && j >= 0 && j < arr[i].length && arr[i][j] == 1) {
            num = 1 + dfs(arr, i - 1, j) + dfs(arr, i + 1, j) + dfs(arr, i - 1, j + 1) + dfs(arr, i - 1, j - 1);
        }
        return num;
    }

    public static int method12(int[] arr, int left, int right, int tar) {
        if (left > right) return -1;

        if (arr[left] == tar) return left;
        if (arr[right] == tar) return right;

        int mid = (left + right) / 2;
        if (arr[mid] == tar) return mid;

        if (arr[left] < arr[mid] && arr[left] > tar) {
            return method12(arr, mid + 1, right, tar);
        } else {
            return method12(arr, left, mid - 1, tar);
        }

    }
}
