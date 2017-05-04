package com.yo.sort.part3;

/**相邻两数最大差值
    题目：
     有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
     给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
     测试样例：
     [1,2,5,4,6],5
     返回：2
 * Created by Yo on 2017/2/22.
 */
public class Gap {
    public static void main(String[] args) {
        int[] data = {1,4,6,5,9,10};//3
        //print
        System.out.println(maxGap(data, data.length));
    }

    public static int maxGap(int[] A, int n) {
        if( A==null || n<2 ) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            min = Math.min(A[i], min);
            max = Math.max(A[i], max);
        }
        if( min == max ) {
            return 0;
        }
        boolean[] hasNum = new boolean[n+1];
        int[] mins = new int[n+1];
        int[] maxs = new int[n+1];
        int bid = 0;
        for(int i=0; i<n; i++) {
            bid = bucket(A[i], n, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], A[i]) : A[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], A[i]) : A[i];
            hasNum[bid] = true;
        }
        int lastMax=0, res=0, i=0;
        while( i <= n ) {
            if( hasNum[i++] ) {
                lastMax = maxs[i-1];
                break;
            }
        }
        for(; i<=n; i++) {
            if( hasNum[i] ) {
                res = Math.max(res, mins[i]-lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }
    // 使用long类型是为了防止相乘时溢出
    public static int bucket(long num ,long len, long min, long max) {
        return (int)((num-min)*len / (max-min));
    }
}
