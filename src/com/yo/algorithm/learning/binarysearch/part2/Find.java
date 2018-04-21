package com.yo.algorithm.learning.binarysearch.part2;

/**最左原位：
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。
   给定有序数组arr及它的大小n，请返回所求值。
   测试样例：
       [-1,0,2,3],4
   返回：2
 * Created by Yo on 2017/3/6.
 */
public class Find {
    public static void main(String[] args) {

    }
    public static int findPos(int[] arr, int n) {
        if( arr==null || n==0 ) {
            return -1;
        }
        if( arr[0]>n-1 || arr[n-1]<0 ) {//①数组本身有序，第一个数都比最后一个索引值大，肯定不存在
            return -1;                  //②最后一个数都小于0,则前面的数更不可能出现 arr[i] == i的情况
        }
        int left=0, right=n-1, mid=0, res=-1;
        while( left <= right ) {
            mid = left + (right-left)/2;
            if( arr[mid] > mid ) { // 下标是按1进行递增，中间的值比中间的下标都大，则右边不会存在arr[i]==i的情况
                right = mid - 1;
            } else if( arr[mid] < mid ) { // 左边不存在arr[i]==i 的情况
                left = mid + 1;
            } else {
                res = mid; // 但仍需要在左边进行寻找
                right = mid - 1;
            }
        }
        return res;
    }

    public static int findPosTest(int[] arr, int n) {
        if( arr==null || n<=0 ) {
            return -1;
        }
        if( arr[0]>n-1 || arr[n-1]<0 ) {
            return -1;
        }
        int left=0, right=n-1, mid=0, res=-1;
        while( left <= right ) {
            mid = left + (right-left)/2;
            if( arr[mid] > mid ) {
                right = mid - 1;
            } else if( arr[mid] < mid ){
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}
