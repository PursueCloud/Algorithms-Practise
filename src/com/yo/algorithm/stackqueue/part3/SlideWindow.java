package com.yo.algorithm.stackqueue.part3;

import java.util.Arrays;

/**
 * 滑动窗口练习题
   有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，w=3为例。因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。
   给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
   测试样例：
       [4,3,5,4,3,3,6,7],8,3
   返回：[5,5,5,4,6,7]
 * Created by Yo on 2017/3/4.
 */
public class SlideWindow {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(Arrays.toString(slide2(arr, arr.length, 3)));
    }

    //方法二：最佳方法，时间复杂度：O(n);
    public static int[] slide2(int[] arr, int n, int w) {
        if( w>n || arr==null ) {
            return null;
        }
        int front=0, back=0, left=0;
        int[] result = new int[n-w+1];
        //建立双端队列qmax
        int[] qmax = new int[n];
        for(int i=0; i<n; i++){
            while( back<front && arr[qmax[front-1]]<arr[i] ) {
                front--;
            }
            qmax[front++] = i;
            if( left+w-1 == i ){
                //达到窗口长度
                result[left++] = arr[qmax[back]];
            }
            if( qmax[back]+w-1 == i ){
                //队尾过期
                back++;
            }
        }
        return result;
    }
    /**
     * 普通方法，时间复杂度：O(n*w)
     * @param arr
     * @param n
     * @param w
     * @return
     */
    public static int[] slide(int[] arr, int n, int w) {
        int[] res = new int[n-w+1];
        for(int i=0; i<n-w+1; i++){//循环n-w+1遍
            res[i] = getMax(arr, i, i+w);
        }
        return res;
    }
    //求数组最大值并返回
    public static int getMax(int[] arr,int start,int end){
        int max = arr[start];
        for(int i=start; i<end; i++){
            if( arr[i] > max ){
                max = arr[i];
            }
        }
        return max;
    }

}
