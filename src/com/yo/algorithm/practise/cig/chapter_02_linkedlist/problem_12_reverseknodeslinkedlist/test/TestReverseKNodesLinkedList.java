package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_12_reverseknodeslinkedlist.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_12_reverseknodeslinkedlist.impl.ReverseKNodesLinkedList.reverseKNodes2;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 测试 - 反转链表中的每k个节点
 */
public class TestReverseKNodesLinkedList {

    public static void main(String[] args) {
        SingleNode head = null;
        int K = 3;
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new SingleNode(1);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        head.next.next.next.next = new SingleNode(5);
        head.next.next.next.next.next = new SingleNode(6);
        head.next.next.next.next.next.next = new SingleNode(7);
        head.next.next.next.next.next.next.next = new SingleNode(8);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");
    }
}
