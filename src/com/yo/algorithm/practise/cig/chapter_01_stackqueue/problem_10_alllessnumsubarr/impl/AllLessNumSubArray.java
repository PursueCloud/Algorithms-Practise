package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_10_alllessnumsubarr.impl;

import java.util.LinkedList;

/**
 * 求最大值减去最小值<=指定值num的子数组数量
 */
public class AllLessNumSubArray {

    public static int getNum(int[] arr, int num) {
        if (arr==null || arr.length==0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                //不符合规则(max(arr[i...j]) - min(arr[i...j]) <= num)时跳出
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
//            if (j - i > 0) {
//                System.out.println("符合条件的子数组start: " + i + "，子数组end：" + (j-1));
//            }
            res += j - i;
            i++;
        }

        return res;
    }
}
