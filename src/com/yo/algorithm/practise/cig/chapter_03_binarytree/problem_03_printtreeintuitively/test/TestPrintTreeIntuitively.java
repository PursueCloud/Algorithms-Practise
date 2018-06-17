package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_03_printtreeintuitively.test;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_03_printtreeintuitively.impl.PrintTreeIntuitively.printTreeIntuitive;

/**
 * 测试 - 直观地打印二叉树
 */
public class TestPrintTreeIntuitively {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(-222222222);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(Integer.MIN_VALUE);
        head.right.left = new TreeNode(55555555);
        head.right.right = new TreeNode(66);
        head.left.left.right = new TreeNode(777);
        printTreeIntuitive(head);

        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);
        head.left.left.right = new TreeNode(7);
        printTreeIntuitive(head);

        head = new TreeNode(1);
        head.left = new TreeNode(1);
        head.right = new TreeNode(1);
        head.left.left = new TreeNode(1);
        head.right.left = new TreeNode(1);
        head.right.right = new TreeNode(1);
        head.left.left.right = new TreeNode(1);
        printTreeIntuitive(head);
    }
}
