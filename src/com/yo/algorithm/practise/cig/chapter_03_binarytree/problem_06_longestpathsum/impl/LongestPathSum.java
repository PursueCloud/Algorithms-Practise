package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_06_longestpathsum.impl;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度
 */
public class LongestPathSum {

    public static int getMaxLength(TreeNode root, int k) {
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        sumMap.put(0, 0);
        return preOrder(root, k, 0, 1, 0, sumMap);
    }
    private static int preOrder(TreeNode root, int k, int preSum, int level,
                                int maxLen, Map<Integer, Integer> sumMap) {
        if (root == null) {
            return maxLen;
        }
        int currSum = preSum + root.value;
        if (!sumMap.containsKey(currSum)) {
            sumMap.put(currSum, level);
        }
        if (sumMap.containsKey(currSum - k)) {
            maxLen = Math.max(level - sumMap.get(currSum - k), maxLen);
        }
        maxLen = preOrder(root.left, k, currSum, level+1, maxLen, sumMap);
        maxLen = preOrder(root.right, k, currSum, level+1, maxLen, sumMap);
        if (level == sumMap.get(currSum)) {
            sumMap.remove(currSum);
        }
        return maxLen;
    }
}
