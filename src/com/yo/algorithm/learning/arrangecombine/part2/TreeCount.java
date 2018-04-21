package com.yo.algorithm.learning.arrangecombine.part2;

/**二叉树统计练习题：
   求n个无差别的节点构成的二叉树有多少种不同的结构？
   给定一个整数n，请返回不同结构的二叉树的个数。保证结果在int范围内。
   测试样例：
      1
   返回：1
 * Created by Yo on 2017/3/11.
 */
public class TreeCount {
    public static void main(String[] args) {

    }
    public static int countWays(int n) {
        int res = 1;
        for(int i=n+1; i<=2*n; i++) {
            res *= i;
        }
        for(int i=2; i<=n+1; i++) {
            res /= i;
        }
        return res;
    }
}
