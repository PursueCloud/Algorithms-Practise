package com.yo.algorithm.practise.cig.chapter_05_string.problem_05_atoi.test;

import com.yo.algorithm.practise.cig.chapter_05_string.problem_05_atoi.impl.Atoi;

public class AtoiTest {

    public static void main(String[] args) {
        String str = "1234";
        int num = Atoi.atoi(str);
        System.out.println(num);
    }
}
