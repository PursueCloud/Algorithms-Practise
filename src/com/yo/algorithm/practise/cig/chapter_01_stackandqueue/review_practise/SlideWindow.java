package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.review_practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口问题
 * 思路：
 *      1、
 * 解法：
 *      如思路所述
 */
public class SlideWindow {

    /**
     *
     * @param array 给定数组
     * @param w 窗口大小
     * @return
     */
    public static int[] getMaxValArr(int[] array, int w) {
        if (array==null || w<1 || array.length<2) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();

        List<Integer> maxValList = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            while (!qmax.isEmpty() && array[qmax.peekLast()]<=array[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (!qmax.isEmpty() && qmax.peekFirst() == i-w) {
                qmax.pollFirst();
            }
            if (i >= w-1) {
                maxValList.add(array[qmax.peekFirst()]);
            }
        }
        //构造返回结果
        int[] result = new int[maxValList.size()];
        for (int i=0; i<maxValList.size(); i++) {
            result[i] = maxValList.get(i);
        }
        return result;
    }
}
