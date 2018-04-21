package com.yo.algorithm.learning.arrangecombine.part1;

/**方格移动练习题：
   在XxY的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法
   给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。
   测试样例：
       2,2
   返回：2
 * Created by Yo on 2017/3/11.
 */
public class Robot {
    public static void main(String[] args) {

    }

    public static int countWays(int x, int y) {
        if( x<=0 || y<=0 ) {
            return 0;
        }
        int res = 1;
        for(int i=1; i<x; i++) {
            res = res*(y+i-1)/i;
        }
        return res;
    }
}
