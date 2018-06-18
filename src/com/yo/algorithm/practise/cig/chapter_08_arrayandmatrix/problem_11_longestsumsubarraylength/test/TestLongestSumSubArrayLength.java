package com.yo.algorithm.practise.cig.chapter_08_arrayandmatrix.problem_11_longestsumsubarraylength.test;

import com.yo.algorithm.practise.cig.chapter_08_arrayandmatrix.problem_11_longestsumsubarraylength.impl.LongestSumSubArrayLength;

/**
 * 测试 - 未排序数组中累加和为给定值的最长子数组系列问题
 */
public class TestLongestSumSubArrayLength {

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        printArray(arr);
        System.out.println(LongestSumSubArrayLength.getMaxSubArrayLength(arr, 10));
        arr = new int[]{1, -1, 0 , -1, 1, 1, -1, -1, 0, 0};
        System.out.println(LongestSumSubArrayLength.getMaxSubArrayLengthOfPosAndNegCntEq(arr));
        arr = new int[]{1, 1, 0 , 1, 1, 0, 1, 1, 0, 0};
        System.out.println(LongestSumSubArrayLength.getMaxSubArrayLengthOfZeroAndNegCntEq(arr));
    }
}
