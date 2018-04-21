package com.yo.algorithm.arrangecombine.part1;

/**分糖果练习题：
   n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
   给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
   测试样例：
       10,3
   返回：36
 * Created by Yo on 2017/3/11.
 */
public class Distribution {
    public static void main(String[] args) {

    }
    public static int getWays(int n, int m) {
        return C(n-1, m-1);
    }
    public static int C(int n, int m) {
        if( n < m ) {
            return 0;
        }
        int res1=1, res2=1;
        for(int i=n; i>n-m; i--) {
            res1 *= i;
        }
        for(int i=1; i<=m; i++) {
            res2 *= i;
        }
        return res1/res2;
    }
}
