package com.tan.arithmetic;

import java.util.Arrays;

/**
 * 归并排序
 * 第一步:根据data数组的中间值mid进行分割成两个数组:left数组 right数组
 * 第二步:继续第一步递归直到data数组的每个元素都是单体的
 * 单体其实对应值一个数组里面有两个元素x1,x2
 * 第三步: 比较x1,x2 由小到大 最后每个单体数组都是有序的
 * 第四步:我们采用递归的方式进行left数组/right数组的两两单体数组进行合并
 * 比如left数组中:
 * t1=[4,8]    t2=[5,7]  temp=[] 长度为四
 * 首先比较t1的开始下标与t2的开始下标
 * 如果t1[0]>t2[0] 则把t2[0]放入temp[0]=t2[0] t2的下标加一
 * 如果循环 最后判断 t1或者t2哪些值没有遍历完则依次放入temp中
 * 第五步：最后使用递归方式进行整体合并
 * <p>
 * Created by Administrator on 2020/8/19.
 */
public class MergeSort2 {
    public static void main(String[] args) {

//        int[] data = {2, 8, 4, 5};
        int[] data = {2, 5, 6, 3, 4, 7, 8, 10, 9, 1};
        int[] temp = new int[data.length];
        mergeSort(data, 0, data.length - 1, temp);
        System.out.println(Arrays.toString(data));

    }

    /**
     * 目标是拆分data数组和合并排序
     *
     * @param data  目标数组
     * @param left  left数组的开始下标
     * @param right right数组的结束下标
     * @param temp  临时数组
     */
    public static void mergeSort(int[] data, int left, int right, int[] temp) {

        //确保每个单体数组的下标符合大小
        if (left < right) {
            // 中间值下标
            int mid = (left + right) / 2;
            //向left递归拆分
            mergeSort(data, left, mid, temp);
            //向right递归拆分 加一使用确保left数组right数组没有重复
            mergeSort(data, mid + 1, right, temp);
            //每个单体left数组和right数组进行合并排序
            merge(data, left, mid, right, temp);

        }

    }

    /**
     * 目标是：进行单体数组的排序合并
     *
     * @param data  目标排序数组
     * @param left  left数组的开始下标
     * @param mid   目标数据的中间值下标
     * @param right right数组的结束下标
     * @param temp  临时数据
     */
    public static void merge(int[] data, int left, int mid, int right, int[] temp) {

        //定义left数组的开始下标
        int l = left;
        //定义right数组的开始下标
        int r = mid + 1;
        // 定义临时数组的开始下标
        int t = 0;

        // 开始执行两个数组的排序合并
        while (l <= mid && r <= right) { //确保left数组、right数组都没有跃下标遍历

            if (data[l] <= data[r]) { //遍历到left数组比right数组的值小于等于
                temp[t] = data[l];
                t += 1;
                l += 1;
            }

            if (data[l] > data[r]) {//遍历到left数组比right数组的值大于
                temp[t] = data[r];
                t += 1;
                r += 1;
            }
        }

        // 如果遍历完之后存在left数组或者right数组还没有遍历完
        while (l <= mid) {
            temp[t] = data[l];
            t += 1;
            l += 1;
        }
        while (r <= right) {
            temp[t] = data[r];
            t += 1;
            r += 1;
        }

        // 拷贝temp数组到data数组中
        t = 0; //初始化temp数组的下标
        int temp_l = left; //初始化data数组拷贝的下标
        while (temp_l <= right) { //每一次拷贝都为下一次调用该方法做准备
            // 两个单体数组进行合并
            // 例如 第一次调用
            // left = [2,8]     right=[4,5]
            // 2,4,5,8
            data[temp_l] = temp[t];
            t += 1;
            temp_l += 1;
        }

    }
}
