package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_06_solvehanoiproblemwithstack.test;

import com.yo.algorithm.practise.cig.chapter_01_stackandqueue.review_practise.HanoiProblem;
import com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_06_solvehanoiproblemwithstack.impl.SolveHanoiProblemWithStack;

/**
 * 测试 -- 用栈（递归或栈操作）来解决汉诺塔问题
 */
public class TestSolveHanoiProblemWithStack {

    public static void main(String[] args) {
        System.out.println(SolveHanoiProblemWithStack.solveHanoiProblemRecursive(2, "left", "mid", "right"));
        System.out.println("==================");
        System.out.println(SolveHanoiProblemWithStack.solveHanoiProblemUnRecursive(2, "left", "mid", "right"));
        System.out.println(HanoiProblem.hanoiProblemRecursive(2, "left", "mid", "right"));
        System.out.println(HanoiProblem.hanoiProblemUnRecursive(2, "left", "mid", "right"));
    }
}
