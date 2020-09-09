package com.tan.arithmetic;

/**
 * 二分查找:
 * Created by Administrator on 2020/8/17.
 */
public class DimididateSearcher {
    public static void main(String[] args) {

        // 9
        int[] data = {1, 3, 5, 6, 8, 9, 10, 14, 19};
        DimididateSearcher.dimididateSearch(data, 0, data.length - 1, 3);
    }

    /**
     * @param data  目标数据集合
     * @param left  数据集合范围的开始下标
     * @param right 数据集合范围的结束下标
     * @param res   要查找的目标数据
     */
    public static void dimididateSearch(int[] data, int left, int right, int res) {

        // 递归出口
        if (right == left || (right - left == 1)) {
            if (data[left] == res || data[right] == res) {
                System.out.println("yes");
                return;
            } else {
                System.out.println("no");
                return;
            }
        }

        // 递归入口
        int mid = (right + left) / 2;
        if (data[mid] == res) {
            System.out.println("yes");
        } else if (data[mid] > res) {
            // 中间值大于目标值
            dimididateSearch(data, left, mid, res);
        } else if (data[mid] < res) {
            // 中间值小于 目标值
            dimididateSearch(data, mid, right, res);
        }

    }
}
