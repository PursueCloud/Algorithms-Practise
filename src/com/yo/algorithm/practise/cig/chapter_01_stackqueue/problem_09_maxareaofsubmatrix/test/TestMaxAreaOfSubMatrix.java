package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_09_maxareaofsubmatrix.test;

import com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_09_maxareaofsubmatrix.impl.MaxAreaOfSubMatrix;

/**
 * 最大子矩阵大小-测试
 */
public class TestMaxAreaOfSubMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        };
        System.out.println(com.yo.algorithm.practise.cig.chapter_01_stackqueue.practise.MaxAreaOfSubMatrix.maxRecSize(matrix));
    }
}
