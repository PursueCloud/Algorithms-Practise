package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_09_maxareaofsubmatrix.test;

import com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_09_maxareaofsubmatrix.impl.MaxAreaOfSubMatrix;

/**
 * 最大子矩阵大小-测试
 */
public class TestMaxAreaOfSubMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        };
        int[][] matrix2 = {
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 0, 0}
        };
        System.out.println(MaxAreaOfSubMatrix.maxRecArea(matrix1));
        System.out.println(MaxAreaOfSubMatrix.maxRecArea(matrix2));
    }
}
