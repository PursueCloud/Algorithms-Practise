package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_01_traverse.test;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_15_bsttodoublelinkedlist.impl.entity.TreeNode;
import com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_01_traverse.impl.TraverseBinaryTree;

/**
 * 测试 - 用递归和非递归的方式实现二叉树的先序、中序和后续遍历
 */
public class TestTraverseBinaryTree {

    /**
     * 测试结果：
     *    ==============recursive==============
          pre-order: 5 3 2 1 4 8 7 6 10 9 11
          in-order: 1 2 3 4 5 6 7 8 9 10 11
          pos-order: 1 2 4 3 6 7 9 11 10 8 5
          ============unrecursive=============
          pre-order: 5 3 2 1 4 8 7 6 10 9 11
          in-order: 1 2 3 4 5 6 7 8 9 10 11
          pos-order: 1 2 4 3 6 7 9 11 10 8 5
          pos-order: 1 2 4 3 6 7 9 11 10 8 5
     * @param args
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        TraverseBinaryTree.Recursive.preOrderTraverse(head);
        System.out.println();
        System.out.print("in-order:  ");
        TraverseBinaryTree.Recursive.inOrderTraverse(head);
        System.out.println();
        System.out.print("pos-order: ");
        TraverseBinaryTree.Recursive.posOrderTraverse(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        System.out.print("pre-order: ");
        TraverseBinaryTree.UnRecursive.preOrderTraverse(head);
        System.out.println();
        System.out.print("in-order:  ");
        TraverseBinaryTree.UnRecursive.inOrderTraverse(head);
        System.out.println();
        System.out.print("pos-order(2-stack): ");
        TraverseBinaryTree.UnRecursive.posOrderTraverse_2Stack(head);
        System.out.println();
        System.out.print("pos-order(1-stack): ");
        TraverseBinaryTree.UnRecursive.posOrderTraverse_1Stack(head);
//        posOrderUnRecur2(head);
    }
}
