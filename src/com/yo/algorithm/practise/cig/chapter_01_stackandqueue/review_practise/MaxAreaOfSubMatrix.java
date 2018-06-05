package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.review_practise;

import java.util.Stack;

/**
 * 最大子矩阵大小
 */
public class MaxAreaOfSubMatrix {

    /**
     * 求指定的矩阵中最大子矩阵的大小
     * @param matrix 二维数组，即矩阵
     * @return
     */
    public static int maxRecArea(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                height[j] = matrix[i][j]==0 ? 0 : height[j]+1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    private static int maxRecFromBottom(int[] height) {
        if (height==null || height.length==0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<height.length; i++) {
            while (!stack.isEmpty() && height[i]<=height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int currArea = (i - k - 1) * height[j];
                maxArea = Math.max(currArea, maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int currArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }

}
