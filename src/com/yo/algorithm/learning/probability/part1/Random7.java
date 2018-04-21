package com.yo.algorithm.learning.probability.part1;

import java.util.Random;

/** 随机函数练习题:
   给定一个等概率随机产生1~5的随机函数，除此之外，不能使用任何额外的随机机制，请实现等概率随机产生1~7的随机函数。
   (给定一个可调用的Random5::random()方法,可以等概率地随机产生1～5的随机函数)
 * Created by Yo on 2017/3/11.
 */
public class Random7 {
    private static Random rand = new Random(123456);
    // 随机产生[1,5]
    private static int rand5() {
        return 1 + rand.nextInt(5);
    }

    // 通过rand5实现rand7
    public static int randomNumber() {
        int res = 30;
        while( res > 20 ){
            res = 5 * (rand5() - 1) + (rand5() - 1);
        }
        return (res % 7) + 1;
    }

}
