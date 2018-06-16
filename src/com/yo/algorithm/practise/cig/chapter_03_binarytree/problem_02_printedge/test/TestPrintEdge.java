package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_02_printedge.test;


import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_02_printedge.impl.PrintEdge.printEdge1;
import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_02_printedge.impl.PrintEdge.printEdge2;

/**
 * 测试 - 打印二叉树的边界节点
 */
public class TestPrintEdge {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);
        head.left.right.left = new TreeNode(7);
        head.left.right.right = new TreeNode(8);
        head.right.left.left = new TreeNode(9);
        head.right.left.right = new TreeNode(10);
        head.left.right.right.right = new TreeNode(11);
        head.right.left.left.left = new TreeNode(12);
        head.left.right.right.right.left = new TreeNode(13);
        head.left.right.right.right.right = new TreeNode(14);
        head.right.left.left.left.left = new TreeNode(15);
        head.right.left.left.left.right = new TreeNode(16);

        printEdge1(head);
        printEdge2(head);
    }
}
