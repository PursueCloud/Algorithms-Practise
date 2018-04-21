package com.yo.algorithm.learning.probability.part1;

/**足球比赛练习题
   有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？
   给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
   测试样例：
       4
   返回：[3,7]
 * Created by Yo on 2017/3/11.
 */
public class Championship {
    public int[] calc(int k) {
        int a=1, b=1;
        //求总的组合数
        for(int i=2*k-1; i>0; i-=2) {
            a *= i;
        }
        //强队不相遇数目(C(k+1,k-1))
        for(int i=3; i<=k+1; i++) {
            b *= i;
        }
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        int[] res = new int[2];
        res[0] = a - b;
        res[1] = a;

        return res;
    }

    public static int gcd(int a,int b){
        while( b > 0 ) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

}
