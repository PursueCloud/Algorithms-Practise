package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_15_bsttodoublelinkedlist.impl;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_15_bsttodoublelinkedlist.impl.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 搜索二叉树转换为双向链表
 */
public class BSTToDoubleLinkedList {

    /**
     * 时间复杂度：O(N)，额外空间复杂度：O(N)，因为使用到了队列
     * 思路：用队列保存二叉树的中序遍历结果，然后将队列中的节点连接起来
     * @param root
     * @return
     */
    public static TreeNode transform1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        inOrderToQueue(root, queue);
        if (queue.isEmpty()) {
            return root;
        }
        root = queue.poll();
        TreeNode pre = root;
        //头节点left/last指针指向空
        pre.left = null;
        TreeNode curr = null;
        //按顺序连接队列中的节点
        while (!queue.isEmpty()) {
            curr = queue.poll();
            pre.right = curr;
            curr.left = pre;
            pre = curr;
        }
        //最后一个节点right/next指针指向空
        pre.right = null;
        return root;
    }
    private static void inOrderToQueue(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) {
            return;
        }
        //递归中序遍历二叉树，左 -> 中/根节点 -> 右
        inOrderToQueue(root.left, queue);
        queue.add(root);
        inOrderToQueue(root.right, queue);
    }

    /**
     * 时间复杂度：O(N)，额外空间复杂度：O(h)，h为整棵树的高度
     * 思路：递归获取二叉树转换为特殊双向队列的结果，然后将各个结果与树的根节点连接起来，
     * 最后返回最后一个节点即可，而最后一个节点，即指向转化为双向队列的头节点
     * @param root
     * @return
     */
    public static TreeNode transform2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode last = process(root);
        //最后一个节点的下一节点即是转换后的头节点
        root = last.right;
        //最后一个节点与头节点的连接
        last.right = null;
        return root;
    }
    private static TreeNode process(TreeNode root) {
        if (root == null) {
            return null;
        }
        //左子树转换为特殊双向链表（该链表的最后一个节点指向头节点），获取转换后的最后一个节点
        TreeNode leftEnd = process(root.left);
        //同理，处理右子树，获取转换后的最后一个节点
        TreeNode rightEnd = process(root.right);
        TreeNode leftStart = leftEnd!=null ? leftEnd.right : null;
        TreeNode rightStart = rightEnd!=null ? rightEnd.right : null;

        //将左子树转换后的链表以及右子树转换后的链表与root节点连接起来，需要判断多种情况：
        // ①左子树和右子树都成功转换（即左、右子树均不为空）②左子树成功转换（左子树不为空）
        // ③右子树成功转换（右子树不为空）④左子树和右子树都转换失败（左、右子树均为空）
        if (leftEnd!=null && rightEnd!=null) {
            leftEnd.right = root;
            root.left = leftEnd;
            root.right = rightStart;
            rightStart.left = root;
            rightEnd.right = leftStart;
            return rightEnd;
        } else if (leftEnd != null) {
            leftEnd.right = root;
            root.left = leftEnd;
            root.right = leftStart;
            return root;
        } else if (rightEnd != null) {
            root.right = rightStart;
            rightStart.left = root;
            rightEnd.right = root;
            return rightEnd;
        } else {
            root.right = root;
            return root;
        }

    }
}
