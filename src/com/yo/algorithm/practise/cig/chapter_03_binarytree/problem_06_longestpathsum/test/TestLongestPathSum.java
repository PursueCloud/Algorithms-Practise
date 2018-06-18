package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_06_longestpathsum.test;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_03_printtreeintuitively.impl.PrintTreeIntuitively.printTreeIntuitive;
import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_06_longestpathsum.impl.LongestPathSum.getMaxLength;

/**
 * 测试 - 在二叉树中找到累加和为指定值的最长路径长度
 */
public class TestLongestPathSum {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(-3);
        head.left = new TreeNode(3);
        head.right = new TreeNode(-9);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(0);
        head.left.right.left = new TreeNode(1);
        head.left.right.right = new TreeNode(6);
        head.right.left = new TreeNode(2);
        head.right.right = new TreeNode(1);
        printTreeIntuitive(head);
        System.out.println(getMaxLength(head, 6));
        System.out.println(getMaxLength(head, -9));
    }
}
