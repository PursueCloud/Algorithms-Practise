package com.yo.algorithm.learning.dynamicplan.part2;

/**台阶问题练习题:
   有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
   给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
   测试样例：
      1
   返回：1
 * Created by Yo on 2017/3/12.
 */
public class GoUpstairs {
    public int countWays(int n) {
        // write code here
        int max=100002, modNum=1000000007;
        int[] method = new int[max];
        method[0] = 0;
        method[1] = 1;
        method[2] = 2;
        for(int i=3; i<n+1; i++) {
            method[i] = (method[i-1]+method[i-2]) % modNum;
        }
        return method[n];
    }
    /**
     * 暴力搜索
     */
    public int s1(int n) {
        if( n < 1 ) {
            return 0;
        }
        if( n==1 || n==2 ) {
            return n;
        }
        return s1(n-1) + s1(n-1);
    }
    /**
     * 记忆化搜索
     */
    public int s2(int n) {
        return 0;
    }
}
