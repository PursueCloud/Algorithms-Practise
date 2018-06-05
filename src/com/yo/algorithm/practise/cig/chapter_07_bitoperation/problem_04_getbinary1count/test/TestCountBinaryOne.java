package com.yo.algorithm.practise.cig.chapter_07_bitoperation.problem_04_getbinary1count.test;

import com.yo.algorithm.practise.cig.chapter_07_bitoperation.problem_04_getbinary1count.impl.BinaryOne;

public class TestCountBinaryOne {
    public static void main(String[] args) {
        int n0 = 2;//0010
        int n1 = 5;//0101
        int n2 = 7;//0111
        System.out.println("=================count1================= n &= n-1");
        System.out.println(BinaryOne.count1(n0));
        System.out.println(BinaryOne.count1(n1));
        System.out.println(BinaryOne.count1(n2));
        System.out.println("=================count2================= n -= n & (~n + 1)");
        System.out.println(BinaryOne.count2(n0));
        System.out.println(BinaryOne.count2(n1));
        System.out.println(BinaryOne.count2(n2));
    }
}
