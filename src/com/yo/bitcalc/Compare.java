package com.yo.bitcalc;

/**比较练习题：
   对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。若两数相同，返回任意一个。
   给定两个整数a和b，请返回较大的数。
   测试样例：
       1,2
   返回：2
 * Created by Yo on 2017/3/11.
 */
public class Compare {
    public static void main(String[] args) {
        System.out.println(getMax(6, 4));
    }

    /**
     * 最优解
     * @param a
     * @param b
     * @return
     */
    public static int getMax(int a, int b) {
        int a0 = sign(a);//a的符号,1代表正数
        int b0 = sign(b);//b的符号,0代表负数
        int c0 = sign(a-b);
        int difSab = a0 ^ b0;//a,b符号是否相同，相同为0,不同为1
        int sameSab = flip(difSab);//a,b符号不同为0
        int returnA = difSab*a0 + sameSab*c0;
        int returnB = flip(returnA);
        return a*returnA + b*returnB;
    }
    private static int flip(int n) {
        return n ^ 1;//若是负数则为0 M
    }
    private static int sign(int n) {
        return flip((n>>31) & 1);//负数符号位为1，做&运算保留，经过flip得0
    }
    /**
     * 简单的解法
     * @param a
     * @param b
     * @return
     */
    public static int getMax2(int a, int b) {
        // write code here
        int c = a - b;
        int returnC = (c >> 31) & 1;
        int returnB = returnC ^ 1;
        return a*returnB + b*returnC;
    }
    public static int getMax2Test(int a, int b) {
        int c = a - b;
        int returnC = (c>>31) & 1;
        int returnB = returnC ^ 1;
        return returnB*a + returnC*b;
    }
}

