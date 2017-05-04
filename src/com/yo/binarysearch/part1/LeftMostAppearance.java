package com.yo.binarysearch.part1;

/**元素最左出现练习题：
   对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
   给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
   测试样例：
       [1,2,3,3,4],5,3
   返回：2
 * Created by Yo on 2017/3/6.
 */
public class LeftMostAppearance {
    public static void main(String[] args) {

    }
    public static int findPos(int[] arr, int n, int num) {
        if( arr==null || n<=0 ) {
            return -1;
        }
        int index=-1;
        int left = 0;
        int right = n - 1;
        while( left <= right ) {
            int mid = left + (right-left)/2;
            if( arr[mid] > num ) {
                right = mid - 1;
            } else if( arr[mid] < num ) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }

}
