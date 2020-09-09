package com.tan.lanqiao;

import org.jcp.xml.dsig.internal.dom.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * 找出一个数组里面的唯一重复那个数
 * Created by Administrator on 2020/8/25.
 */
public class UniqueMath1_2 {

    public static void main(String[] args) {

        //造数据
        int[] arr = makeData(1001);
        System.out.println(Arrays.toString(arr));

        // 找去重复的那个数
        // 方式一 : 位运算
        int res = bitArithmetic(arr);
        System.out.println(res);

        // 方式二: 计数和为二
        int res1 = countTwo(arr);
        System.out.println(res1);

        // 方式三: 利用set集合
        int res2 = useSet(arr);
        System.out.println(res2);

    }

    public static int useSet(int[] arr) {

        HashSet<Integer> set = new HashSet<Integer>();

        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if (set.contains(temp)) {
                res = temp;
                break;
            } else {
                set.add(temp);
            }
        }

        return res;

    }

    public static int countTwo(int[] arr) {

        // 临时空间
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            temp[index]++;
        }

        int res = -1;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 2) {
                res = i;
                break;
            }
        }

        return res;

    }

    public static int bitArithmetic(int[] arr) {

        // 定义异或变量 A^0 = A  A^A = 0
        int x = 0;
        for (int i = 1; i < arr.length; i++) {
            x ^= i;
        }

        // 统计
        for (int i = 0; i < arr.length; i++) {
            x ^= arr[i];
        }

        //返回
        return x;

    }

    public static int[] makeData(int n) {

        Random random = new Random();
        int[] arr = new int[n];
        // 填充数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // 随机数
        int rand = random.nextInt(n);
        arr[arr.length - 1] = rand;

        return arr;
    }

}
