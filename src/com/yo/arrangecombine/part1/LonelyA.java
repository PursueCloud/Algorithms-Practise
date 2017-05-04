package com.yo.arrangecombine.part1;

/**孤傲的A练习题:
   A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。现在问你满足A的要求的对列有多少种？
   给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。
   测试样例：
       6,1,2,3
   返回 288
 * Created by Yo on 2017/3/11.
 */
public class LonelyA {
    public int getWays(int n, int A, int b, int c) {
        //a在头
        if(n <= 3) {
            return 0;
        }
        int temp=1, num=1;
        //A在 队列头，尾
        while( temp <= n ) {
            num *= temp++;
        }
        return num - 4*num/n + 2*num/n/(n-1);
    }
}
