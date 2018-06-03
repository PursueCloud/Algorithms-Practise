package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_10_alllessnumsubarr.test;

import com.yo.algorithm.practise.cig.chapter_01_stackqueue.practise.AllLessNumSubArray;

import java.util.Arrays;

/**
 * 最大值-最小值<=指定值num的子数组数量-测试
 */
public class TestAllLessNumSubArr {
    public static int[] getRandomArray(int len) {
        if (len < 0) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    /**
     * 测试结果：
     *         原数组为：[1, 9, 0, 3, 4]
     *         6
     *         子数组分别为：[1],[9],[0],[3],[4],[3, 4]
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 9, 0, 3, 4};//getRandomArray(5);
        System.out.println("原数组为：" + Arrays.toString(arr));
        System.out.println(AllLessNumSubArray.getNum(arr, 2));
    }
}
