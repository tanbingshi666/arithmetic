package com.tan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2020/9/5.
 */
public class Main {
    public static void main(String[] args) {

    }

    public static boolean method(int[] arr) {
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                }
            }
        }

        return flag;
    }


    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> arrays = new ArrayList<String>();

        int begin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                continue;
            } else {
                if (nums[i - 1] == nums[i]) {
                    arrays.add(begin + "");
                } else {
                    arrays.add(begin + "->" + nums[i - 1]);
                }
                begin = nums[i];
            }
            if (i == nums.length - 1) {
                if (nums[i] - nums[i - 1] > 1) {
                    arrays.add(begin + "");
                } else {
                    arrays.add(begin + "->" + nums[i]);
                }
            }
        }
        return arrays;
    }

}

