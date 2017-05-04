package com.yo.arrangecombine.part2;

/**排队买票练习题:
   2n个人排队买票，n个人拿5块钱，n个人拿10块钱，票价是5块钱1张，每个人买一张票，售票员手里没有零钱，问有多少种排队方法让售票员可以顺利卖票。
   给定一个整数n，请返回所求的排队方案个数。保证结果在int范围内。
   测试样例：
       1
   返回：1
 * Created by Yo on 2017/3/11.
 */
public class BuyTickets {
    public static void main(String[] args) {

    }

    public int countWays(int n) {
        int res = 1;
        for(int i=2*n; i>=n+1; i--) {
            res *= i;
        }
        for(int i=2; i<=n; i++) {
            res /= i;
        }
        return res/(n+1);
    }
}
