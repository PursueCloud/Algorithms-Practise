package com.yo.algorithm.learning.binarysearch.part2;

/** 快速N次方练习题：
   如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
   给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
   测试样例：
       2,3
   返回：8
 * Created by Yo on 2017/3/6.
 */
public class QuickPower {
    public static void main(String[] args) {
        System.out.println(getPower(2, 3));
    }

    public static int getPower(int k, int N) {
        if( k == 0 ) {
            return 0;
        }
        if( k==1 || N==0) {
            return 1;
        }
        long modNum = 1000000007;
        long res=1, tmp=k;
        int factor = N;
        while( factor > 0 ){
            if( (factor&1) != 0 ){
                res = (res*tmp)%modNum;
            }
            tmp = (tmp*tmp)%modNum;
            factor >>= 1;
        }
        return (int)res;
    }
}
