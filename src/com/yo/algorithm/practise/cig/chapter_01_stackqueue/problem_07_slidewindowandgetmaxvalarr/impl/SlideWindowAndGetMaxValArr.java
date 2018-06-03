package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_07_slidewindowandgetmaxvalarr.impl;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组(滑动窗口问题）
 * 时间复杂度：O（N），空间复杂度：O（N）
 */
public class SlideWindowAndGetMaxValArr {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr==null || w<1 || arr.length<w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i=0; i<arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]) {
                qmax.pollLast();
            }
            //队列为空或队尾元素所在值比arr[i]大，则将i添加到队尾
            qmax.addLast(i);
            //判断当前队列队头元素是否已经过期，如果是，则弹出的队头
            if (qmax.peekFirst() == i-w) {
                qmax.pollFirst();
            }
            //如果当前窗口已经到达，则将队头元素座位当前窗口的最大值
            if (i >= w-1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
