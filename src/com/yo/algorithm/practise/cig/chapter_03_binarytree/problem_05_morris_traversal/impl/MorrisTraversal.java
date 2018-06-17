package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_05_morris_traversal.impl;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

/**
 * 遍历二叉树的神级方法（morris遍历），时间复杂度：O(N)，额外空间复杂度：O(1)
 */
public class MorrisTraversal {

    /**
     * 中序遍历
     * @param root
     */
    public static void morrisInTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr1 = root;
        TreeNode curr2 = null;
        while (curr1 != null) {
            curr2 = curr1.left;
            if (curr2 != null) {
                while (curr2.right!=null && curr2.right!=curr1) {
                    curr2 = curr2.right;
                }
                if (curr2.right == null) {
                    curr2.right = curr1;
                    curr1 = curr1.left;
                    continue;
                } else {
                    curr2.right = null;
                }
            }
            System.out.print(curr1.value + " ");
            curr1 = curr1.right;
        }
        System.out.println();
    }
    /**
     * 先序遍历
     * @param root
     */
    public static void morrisPreTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr1 = root;
        TreeNode curr2 = null;
        while (curr1 != null) {
            curr2 = curr1.left;
            if (curr2 != null) {
                while (curr2.right!=null && curr2.right!=curr1) {
                    curr2 = curr2.right;
                }
                if (curr2.right == null) {
                    curr2.right = curr1;
                    System.out.print(curr1.value + " ");
                    curr1 = curr1.left;
                    continue;
                } else {
                    curr2.right = null;
                }
            } else {
                System.out.print(curr1.value + " ");
            }
            curr1 = curr1.right;
        }
        System.out.println();
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void morrisPosTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr1 = root;
        TreeNode curr2 = null;
        while (curr1 != null) {
            curr2 = curr1.left;
            if (curr2 != null) {
                while (curr2.right!=null && curr2.right!=curr1) {
                    curr2 = curr2.right;
                }
                if (curr2.right == null) {
                    curr2.right = curr1;
                    curr1 = curr1.left;
                    continue;
                } else {
                    curr2.right = null;
                    printEdge(curr1.left);
                }
            }
            curr1 = curr1.right;
        }
        printEdge(root);
        System.out.println();
    }
    private static void printEdge(TreeNode root) {
        TreeNode tail = reverseEdge(root);
        TreeNode curr = tail;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.right;
        }
        reverseEdge(tail);
    }
    private static TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

}
