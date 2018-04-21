package com.yo.algorithm.arrangecombine.part2;

/**进出栈练习题:
   n个数进出栈的顺序有多少种？假设栈的容量无限大。
   给定一个整数n，请返回所求的进出栈顺序个数。保证结果在int范围内。
   测试样例：
       1
   返回：1
 * Created by Yo on 2017/3/11.
 */
public class Stack {
    public static void main(String[] args) {

    }
    public static int countWays(int n) {
        if( n <= 1 ) {
            return 1;
        }
        int res = 1;
        for(int i=0; i<n; i++) {
            res *= 2*n - i;
        }
        for(int i=n+1; i>1; i--) {
            res /= i;
        }
        return res;
    }
}
