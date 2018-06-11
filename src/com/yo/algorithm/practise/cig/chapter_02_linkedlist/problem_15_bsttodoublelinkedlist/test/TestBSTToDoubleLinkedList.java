package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_15_bsttodoublelinkedlist.test;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_15_bsttodoublelinkedlist.impl.entity.TreeNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_15_bsttodoublelinkedlist.impl.BSTToDoubleLinkedList.*;

/**
 * 测试 - 搜索二叉树转换为双向队列
 */
public class TestBSTToDoubleLinkedList {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(2);
        head.right = new TreeNode(9);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.left.right.right = new TreeNode(4);
        head.right.left = new TreeNode(7);
        head.right.right = new TreeNode(10);
        head.left.left = new TreeNode(1);
        head.right.left.left = new TreeNode(6);
        head.right.left.right = new TreeNode(8);

        printBSTInOrder(head);
        head = transform1(head);
        printDoubleLinkedList(head);

        head = new TreeNode(5);
        head.left = new TreeNode(2);
        head.right = new TreeNode(9);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.left.right.right = new TreeNode(4);
        head.right.left = new TreeNode(7);
        head.right.right = new TreeNode(10);
        head.left.left = new TreeNode(1);
        head.right.left.left = new TreeNode(6);
        head.right.left.right = new TreeNode(8);

        printBSTInOrder(head);
        head = transform2(head);
        printDoubleLinkedList(head);
    }
    public static void printBSTInOrder(TreeNode head) {
        System.out.print("BST in-order: ");
        if (head != null) {
            inOrderPrint(head);
        }
        System.out.println();
    }

    public static void inOrderPrint(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value + " ");
        inOrderPrint(head.right);
    }
    public static void printDoubleLinkedList(TreeNode head) {
        System.out.print("Double Linked List: ");
        TreeNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.right;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.left;
        }
        System.out.println();
    }
}
