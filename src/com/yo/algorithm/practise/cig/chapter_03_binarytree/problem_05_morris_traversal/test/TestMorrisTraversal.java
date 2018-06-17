package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_05_morris_traversal.test;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_03_printtreeintuitively.impl.PrintTreeIntuitively.printTreeIntuitive;
import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_05_morris_traversal.impl.MorrisTraversal.morrisInTraverse;
import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_05_morris_traversal.impl.MorrisTraversal.morrisPosTraverse;
import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_05_morris_traversal.impl.MorrisTraversal.morrisPreTraverse;

/**
 * 测试 - 遍历二叉树的神级方法（morris遍历）
 */
public class TestMorrisTraversal {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(7);
        printTreeIntuitive(head);
        morrisInTraverse(head);
        morrisPreTraverse(head);
        morrisPosTraverse(head);
        printTreeIntuitive(head);
    }
}
