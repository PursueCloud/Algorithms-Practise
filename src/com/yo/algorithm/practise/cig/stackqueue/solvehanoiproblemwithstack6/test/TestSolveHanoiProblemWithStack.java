package com.yo.algorithm.practise.cig.stackqueue.solvehanoiproblemwithstack6.test;

import com.yo.algorithm.practise.cig.stackqueue.practise.HanoiProblem;
import com.yo.algorithm.practise.cig.stackqueue.solvehanoiproblemwithstack6.impl.SolveHanoiProblemWithStack;

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
