package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_01_traverse.impl;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_15_bsttodoublelinkedlist.impl.entity.TreeNode;

import java.util.Stack;

/**
 * 用递归和非递归的方式遍历二叉树
 */
public class TraverseBinaryTree {

    /**
     * 递归的遍历方式
     */
    public static class Recursive {

        /**
         * 先序遍历
         * @param root
         */
        public static void preOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.value + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }

        /**
         * 中序遍历
         * @param root
         */
        public static void inOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderTraverse(root.left);
            System.out.print(root.value + " ");
            inOrderTraverse(root.right);
        }
        /**
         * 后序遍历
         * @param root
         */
        public static void posOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            posOrderTraverse(root.left);
            posOrderTraverse(root.right);
            System.out.print(root.value + " ");
        }
    }

    /**
     * 非递归的遍历方式
     */
    public static class UnRecursive {

        /**
         * 先序遍历
         * @param root
         */
        public static void preOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.value + " ");
                //如果当前节点右孩子不为空，则将其压入栈中
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                //如果当前节点左孩子不为空，则将其压入栈中
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }

        /**
         * 中序遍历
         * @param root
         */
        public static void inOrderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (!stack.isEmpty() || curr!=null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    System.out.print(curr.value + " ");
                    curr = curr.right;
                }
            }
        }
        /**
         * 后序遍历(额外空间复杂度：O(2N)，使用了2个栈)
         * @param root
         */
        public static void posOrderTraverse_2Stack(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            TreeNode curr = null;
            while (!s1.isEmpty()) {
                curr = s1.pop();
                s2.push(curr);
                if (curr.left != null) {
                    s1.push(curr.left);
                }
                if (curr.right != null) {
                    s1.push(curr.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }
        /**
         * 后序遍历（额外空间复杂度：O(N)，只使用一个栈）
         * @param root
         */
        public static void posOrderTraverse_1Stack(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode recent = root;
            TreeNode curr = null;
            while (!stack.isEmpty()) {
                curr = stack.peek();
                if (curr.left!=null && recent!=curr.left && recent!=curr.right) {
                    stack.push(curr.left);
                } else if (curr.right!=null && recent!=curr.right) {
                    stack.push(curr.left);
                } else {
                    System.out.print(stack.pop().value + " ");
                    recent = curr;
                }
            }

        }
    }
}
