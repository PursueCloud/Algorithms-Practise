package com.yo.sort.part3;

/**
 * 最短子数组
     题目：
     对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
     给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
     测试样例：
     [1,4,6,5,9,10],6
     返回：2
 *  Created by Yo on 2017/2/22.
 */
public class Subsequence {
    public static void main(String[] args) {
        int[] data = {1,4,6,4,5,9,10};
        //print
        System.out.println(shortestSubsequence(data, data.length));
    }
    /**
     * 打印数组（每个元素）
     * @param data
     */
    public static void printArray(int[] data) {
        System.out.print("排序后的数据： ");
        for(int a : data) {
            System.out.print(a + " ");
        }
    }

    public static int shortestSubsequence(int[] data, int n) {
        int min=data[n-1], max=data[0];
        int l=0, r=0;
        for(int i=0; i<n; i++){
            if( data[i] >= max ){
                max = data[i];
            } else {
                l = i;
            }
        }
        for(int i=n-1; i>=0; i--){
            if( data[i] <= min ){
                min = data[i];
            } else {
                r = i;
            }
        }
        if( l == r ) {
            return 0;
        } else {
            return l-r+1;
        }
    }

}
