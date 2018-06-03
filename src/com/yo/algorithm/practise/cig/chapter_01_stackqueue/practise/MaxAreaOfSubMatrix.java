package com.yo.algorithm.practise.cig.chapter_01_stackqueue.practise;

import java.util.Stack;

/**
 * 最大子矩阵大小
 */
public class MaxAreaOfSubMatrix {

    public static int maxRecSize(int[][] map) {
        if (map==null || map.length==0 || map[0].length==0) {
            return 0;
        }
        int[] height = new int[map[0].length];
        int maxArea = 0;
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                height[j] = map[i][j]==0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    private static int maxRecFromBottom(int[] height) {
        if (height==null || height.length==0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i=0; i<height.length; i++) {
            while (!stack.isEmpty() && height[i]<=height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int currArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, currArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int currArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

}
