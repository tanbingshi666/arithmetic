package com.tan.arithmetic;

/**
 * 冒泡排序：由小到大排序
 * 3 5 6 3 5 7 9 1 0
 * 相邻的两个数据进行比较
 * <p>
 * Created by Administrator on 2020/8/16.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] date = {3, 5, 6, 3, 5, 7, 9, 1, 0};
//        int[] result = BubbleSort.bubbleSort(date);
        int[] result = BubbleSort.markIndex(date);
        BubbleSort.printData(result);
    }

    // 第一种解法:双循环(由小到大)
    public static int[] bubbleSort(int[] data) {
        // 每执行一次第一层循环就得到最大值或者最小值
        for (int i = 0; i < data.length - 1; i++) {
            // 减i -> 可以推出排完多少个最大值或者最小值
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    // 第二种解法:标记下标(由大到小)
    public static int[] markIndex(int[] data) {
        //3 5 6 3 5 7 9 1 0
        for (int i = 0; i < data.length; i++) {
            int index = i;     //0 2 5
            int max = data[i];// 3 6 7
            for (int j = i; j < data.length; j++) {
                if (max < data[j]) {
                    index = j;
                    max = data[j];
                }
            }

            // 交换
            int temp = data[i];
            data[i] = data[index];
            data[index] = temp;
        }

        return data;

    }

    public static void printData(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print((data[i] + "\t"));
        }
    }


}
