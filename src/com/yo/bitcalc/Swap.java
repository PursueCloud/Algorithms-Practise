package com.yo.bitcalc;

import java.util.Arrays;

/**交换练习题：
   请编写一个算法，不用任何额外变量交换两个整数的值。
   给定一个数组num，其中包含两个值，请不用任何额外变量交换这两个值，并将交换后的数组返回。
   测试样例：
       [1,2]
   返回：[2,1]
 * Created by Yo on 2017/3/11.
 */
public class Swap {
    public static void main(String[] args) {
        int[] num = {3, 4};
        System.out.println(Arrays.toString(getSwap(num)));
    }
    public static int[] getSwap(int[] num) {
        if( num==null || num.length<=1 ) {
            return num;
        }
        int a = num[0];
        int b = num[1];
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        num[0] = a;
        num[1] = b;

        return num;
    }
}
