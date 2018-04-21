package com.yo.algorithm.arrangecombine.part2;

/**括号序列练习题:
   假设有n对左右括号，请求出合法的排列有多少个？合法是指每一个括号都可以找到与之配对的括号，比如n=1时，()是合法的，但是)(为不合法。
   给定一个整数n，请返回所求的合法排列数。保证结果在int范围内。
   测试样例：
       1
   返回：1
 * Created by Yo on 2017/3/11.
 */
public class Parenthesis {
    public static void main(String[] args) {

    }
    public static int countLegalWays(int n) {
        int low=1, high=1;
        for(int i=2; i<=n; i++) {
            high *= n+i;
            low *= i;
        }
        return high/low;
    }
}
