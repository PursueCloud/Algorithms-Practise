package com.yo.algorithm.arrangecombine.part2;

/**高矮排列练习题：
   12个高矮不同的人，排成两排，每排必须是从矮到高排列，而且第二排比对应的第一排的人高，问排列方式有多少种？
   给定一个偶数n，请返回所求的排列方式个数。保证结果在int范围内。
   测试样例：
       1
   返回：1
 * Created by Yo on 2017/3/11.
 */
public class HighAndShort {
    public static void main(String[] args) {

    }

    public static int countWays(int n) {
        if( n < 1 ) {
            return -1;
        }
        int res = 1;
        for(int i=0; i<n/2; i++) {
            res *= n-i;
        }
        for(int i=n/2+1; i>0; i--) {
            res /= i;
        }
        return res;
    }
}
