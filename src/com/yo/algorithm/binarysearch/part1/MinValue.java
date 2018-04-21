package com.yo.algorithm.binarysearch.part1;

/**循环有序数组最小值练习题：
   对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
   给定数组arr及它的大小n，请返回最小值。
   测试样例：
       [4,1,2,3,3],5
   返回：1
 * Created by Yo on 2017/3/6.
 */
public class MinValue {
    public static void main(String[] args) {

    }
    public static int getMin(int[] arr, int n) {
        if( arr==null || arr.length==0 ) {
            return -1;
        }
        int left=0, right=n-1, mid=0;
        while( left < right ) {
            if( left == right-1 ) {//当数组只有两个值的时候
                break;
            }
            if( arr[left] < arr[right] ) {//左边小于右边，left到right范围内是有序的
                return arr[left];
            }
            mid = left + (right-left)/2; // 不使用（left+right)/2，防止数组太大，left和right相加导致溢出
            if( arr[left] > arr[mid] ) { //证明最小值在Left和mid之间
                right = mid;
                continue;
            }
            if( arr[right] < arr[mid] ) {//证明最小值在mid和right之间
                left = mid;
                continue;
            }
            while( left < right ){//当出现等值的情况
                if( arr[left] == arr[mid] ) {
                    left++;
                } else if( arr[left] < arr[mid] ) {
                    return arr[left];
                } else {
                    right = mid;
                    break;
                }
            }
        }
        return Math.min(arr[left], arr[right]);
    }

    public static int getMinTest(int[] arr, int n) {
        if( arr==null || n<=0 ) {
            return -1;
        }
        int left=0, right=n-1, mid=0;
        while( left < right ) {
            if( left == right-1 ) {
                break;
            }
            if( arr[left] < arr[mid] ) {
                return arr[left];
            }
            mid = left + (right-left)/2;
            if( arr[left] > arr[mid] ) {
                right = mid;
                continue;
            }
            if( arr[right] < arr[mid] ) {
                left = mid;
                continue;
            }
            while( left < right ) {
                if( arr[left] == arr[mid] ) {
                    left++;
                } else if( arr[left] < arr[mid] ) {
                    return arr[left];
                } else {
                    right = mid;
                    break;
                }
            }
        }
        return Math.min(arr[left], arr[right]);
    }
}
