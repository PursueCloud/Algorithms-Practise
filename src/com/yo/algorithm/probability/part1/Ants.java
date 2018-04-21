package com.yo.algorithm.probability.part1;

/**蚂蚁习题：
   n只蚂蚁从正n边形的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？
   给定一个正整数n，请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数。
   测试样例：
       3
   返回：[3,4]
 * Created by Yo on 2017/3/11.
 */
public class Ants {
    public static int[] collision(int n) {
        int numerator=2, denominator=1;//numerator:分子, denominator：分母
        for(int i=1; i<=n; i++) {
            denominator *= 2;
        }
        numerator = denominator - numerator;
        int gcd = gcd(denominator, numerator);
        numerator /= gcd;
        denominator /= gcd;
        int[] result = new int[2];
        result[0] = numerator;
        result[1] = denominator;
        return result;
    }
    public static int gcd(int a, int b) {
        while( b > 0 ) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static int[] collisiontTest(int n) {
        int a=2, b=1;
        for(int i=1; i<=n; i++) {
            b *= 2;
        }
        a = b - a;
        int gcd = gcd(b, a);
        a /= gcd;
        b /= gcd;
        int[] res = new int[2];
        res[0] = a;
        res[1] = b;
        return res;
    }
}
