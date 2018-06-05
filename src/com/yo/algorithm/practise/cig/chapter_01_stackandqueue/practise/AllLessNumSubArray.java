package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.practise;

import java.util.LinkedList;

/**
 * 求最大值-最小值<=指定值num的子数组数量
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
                //不符合规则(max(arr[i..j]) - min(arr[i..j]) <= num)则跳出循环
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }

                j++;
            }

            if (!qmin.isEmpty() && qmin.getFirst()==i) {
                qmin.pollFirst();
            }
            if (!qmax.isEmpty() && qmax.getFirst()==i) {
                qmax.pollFirst();
            }
            res += j - i;
            i++;
        }

        return res;
    }
}
