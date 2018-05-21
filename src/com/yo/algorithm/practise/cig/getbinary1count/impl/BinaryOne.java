package com.yo.algorithm.practise.cig.getbinary1count.impl;

/**
 * 求一个数二进制中1的个数
 * 思路：
 *      1、n不等0时，循环n &= n-1，累加循环次数
 *      2、n不等于0是，循环n -= n & (~n+1)，累加循环次数
 * 思路：
 *      如思路所述
 */
public class BinaryOne {

    /**
     * 时间复杂度：O（N），N为1的个数
     * @param n
     * @return
     */
    public static int count1(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

    /**
     * 时间复杂度：O（N），N为1的个数
     * @param n
     * @return
     */
    public static int count2(int n) {
        int res = 0;
        while (n != 0) {
            n -= n & (~n + 1 );
            res++;
        }
        return res;
    }
}
