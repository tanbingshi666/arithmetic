package com.tan.arithmetic;

import java.util.Arrays;

/**
 * 快速排序
 * 第一步: 获取data的中间值mid 也就是根据中间值把data分为两个数组left、right
 * 第二步: 从 left数组起始位置开始遍历 同时right数组从起始位置开始遍历
 * 当left数组遍历(从左往右遍历)到的值x1大于中间值mid
 * 同时ringht数组遍历(从右往左遍历)到的值x2小于中间值mid时
 * 交换x1,x2的值
 * 如此往下执行最终会把left数组的所有值都比mid小 right数组的所有值都比mid大
 * 第三步: 由于我们不能保存left数组/right数组的所有值都是有序的，所有我们要进行进一步处理
 * 怎么处理?
 * 我们可以使用递归的方式
 * Created by Administrator on 2020/8/19.
 */
public class QuickSort2 {
    public static void main(String[] args) {

        int[] data = {15, 7, 10, 8, 16, 10, 9, 11};
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));

    }

    /**
     * @param data  目标排序数组
     * @param left  数组的开始下标
     * @param right 数组的最大下标
     */
    public static void quickSort(int[] data, int left, int right) {

        // 定义left数组的开始下标
        int l = left;
        //定义right数组的最大下标
        int r = right;
        //定义中间值的下标
        int mid = data[(left + right) / 2];
        int temp = 0;
        // 开始遍历left数组 right数组
        // 我们要保证 left数组的遍历下标 l 小于right数组的遍历下标 r
        // 是因为已经以中间值为分割线分成left数组 right数组
        while (l < r) {

            // 开始遍历left数组(从左往右遍历)
            // 遍历知道left数组有值大于中间值才退出循环
            while (data[l] < mid) {
                l += 1;
            }

            // 开始遍历right数组(从右往左遍历)
            // 遍历知道right数组有值小于中间值才退出循环
            while (data[r] > mid) {
                r -= 1;
            }

            //我们要确保left数组和right数组都存在比中间值大或者小的值
            // 如果不存在我我们直接跳出循环 是因为只要有一边不符合要求我们都无法交换数据
            // 至于两边中一边存在比中间值大或者下的值 我们使用递归的方式处理
            if (l >= r) {
                break;
            }

            // 交换数组
            temp = data[l];
            data[l] = data[r];
            data[r] = temp;

            // 交换完之后，如果右边遍历到中间值 那么左边的下标往后移 重要是为递归准备
            if (data[r] == mid) {
                l += 1;
            }

            // 如果左边遍历到中间值 那么右边的下标往前移 重要是为递归准备
            if (data[l] == mid) {
                r -= 1;
            }

        }

        // 经过循环我们可以得出以中间值为基础的左右两边都是比中间值大或者小
        // 当然如果第一次循环可能得不出来

        // 为了避免死循环导致stack溢出
        if (l == r) { //如果相等但是没有错开 那么调用递归是出现异常
            l += 1; //往后移
            r -= 1; //往前移
        }

        // 递归的原因我们不能保证left/right数组都是有序的
        // 递归左边的
        if (left < r) { //当然有其他判断
            quickSort(data, left, r);
        }

        // 递归右边的
        if (l < right) {
            quickSort(data, l, right);
        }

    }
}
