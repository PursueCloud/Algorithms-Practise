package com.yo.algorithm.practise.cig.stackqueue.slidewindowandgetmaxvalarr7.test;

import com.yo.algorithm.practise.cig.stackqueue.slidewindowandgetmaxvalarr7.impl.SlideWindowAndGetMaxValArr;

import java.util.Arrays;

/**
 * 测试 -- 滑动窗口问题
 */
public class TestSlideWindowAndGetMaxValArr {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        System.out.println(Arrays.toString(SlideWindowAndGetMaxValArr.getMaxWindow(arr, w)));
    }
}
