package com.yo.algorithm.sort.part2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 重复值判断
     题目：
     请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
     给定一个int数组A及它的大小n，请返回它是否有重复值。
     测试样例：
     [1,2,3,4,5,5,6],7
     返回：true
 * Created by Yo on 2017/2/22.
 */
public class Checker {

    public static void main(String[] args) {
        int[] data = {1,2,3,4,3,5,6};
        //print
        System.out.println(checkDuplicate(data, data.length));
    }

    /**
     * 不考虑空间复杂度情况，时间复杂度O（n）(最差O(n)，最好O（2）)，空间复杂度O（n）(最差O(n)，最好O（1）)
     * @param a
     * @param n
     * @return
     */
    public static boolean checkDuplicateWithHash(int[] a, int n) {
        if( a==null || n<2 )
            return false;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<n; i++){
           if( !map.containsKey(a[i]+"") ) {
               map.put(a[i] + "", 1);
           } else {
               return true;
           }
        }
        return false;
    }

    public static boolean checkDuplicate(int[] a, int n) {
        if(a==null||n<2)
            return false;
        heapSort(a,n);
        for(int i=1; i<n; i++){
            if(a[i]==a[i-1])
                return true;
        }
        return false;
    }
    /**
     * 交换元素
     * @param data
     * @param m
     * @param n
     */
    public static void swap(int[] data, int m, int n) {
        int swap = data[m];
        data[m] = data[n];
        data[n] = swap;
    }
    public static void heapSort(int[] data, int n) {
        if( data==null || n<=2 ) {
            return;
        }
        for(int i=n/2; i>=0; i--) {
            heapAdjust(data, i, n);
        }
        for(int i=n-1; i>0; i--) {
            swap(data, 0, i);
            heapAdjust(data, 0, i);
        }
    }
    public static void heapAdjust(int[] data, int index, int length) {
        int temp = data[index];
        int childLeft = index*2 + 1;
        while( childLeft < length ) {
            if( childLeft!=length-1 && data[childLeft]<data[childLeft+1] ) {
                childLeft++;
            }
            if( temp > data[childLeft] ) {
                break;
            } else {
                data[index] = data[childLeft];
                index = childLeft;
                childLeft = index*2 + 1;
            }
        }
        data[index] = temp;
    }
}
