package com.yo.algorithm.practise.cig.chapter_08_arrayandmatrix.problem_11_longestsumsubarraylength.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * 求未排序数组中累加和为给定值的最长子数组长度系列问题
 */
public class LongestSumSubArrayLength {

    /**
     * 问题描述：
     *     给定一个无序数组arr，其中元素可正、可负、可0，给定一个整数k。求arr所有的子数组中累加和为k的最长子数组长度
     * 思路：
     *     s(0...j-1) + s(j...i) = s(0...i) => s(j) + s(j+1...i) = s(i) => s(j+1...i) = s(i) - s(j)
     *     sum - k => s(j), sum => s(i)，i > j，所以s(j+1...i) = s(i) - s(j) = sum - (sum-k) = k，
     *     即s(j+1...i)的长度即为累加和为k的子数组长度，即累加和为k的子数组长度len = i - j，取其中最大的长度，即为最长子数组长度
     * @param array 无序数组
     * @param k 指定的累加和
     */
    public static int getMaxSubArrayLength(int[] array, int k) {
        if (array==null || array.length==0) {
            return 0;
        }
        int sum = 0;
        int len = 0;
        //key为某一位置累加和，value为累加和最早出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);//防止0位置被遗漏
        for (int i=0; i<array.length; i++) {
            sum += array[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum - k)) {
                //取最长的长度
                len = Math.max(i - map.get(sum - k), len);
            }
        }
        return len;
    }

    /**
     * 问题描述：
     *     给定一个无序数组arr，其中元素可正、可负、可0.求arr所有的子数组中正数与负数个数相等的最长子数组长度
     * 思路：
     *     将数组中正数换成1，负数换成-1，求替换后的数组中累加和为0的最长子数组长度即可
     * @param array
     * @return
     */
    public static int getMaxSubArrayLengthOfPosAndNegCntEq(int[] array) {
        if (array==null || array.length==0) {
            return 0;
        }
        int[] replaceArr = new int[array.length];
        for (int i=0; i<array.length; i++) {
            replaceArr[i] = array[i] > 0 ? 1 : array[i] < 0 ? -1 : 0;
        }
        return getMaxSubArrayLength(replaceArr, 0);
    }

    /**
     * 问题描述：
     *     给定一个无序数组arr，其中元素只是1或0.求arr所有的子数组中0与1个数相等的最长子数组长度
     * 思路：
     *     将数组中0换成-1，求替换后的数组中累加和为0的最长子数组长度即可
     * @param array
     * @return
     */
    public static int getMaxSubArrayLengthOfZeroAndNegCntEq(int[] array) {
        if (array==null || array.length==0) {
            return 0;
        }
        int[] replaceArr = new int[array.length];
        for (int i=0; i<array.length; i++) {
            replaceArr[i] = array[i] == 0 ? -1 : array[i];
        }
        return getMaxSubArrayLength(replaceArr, 0);
    }
}
