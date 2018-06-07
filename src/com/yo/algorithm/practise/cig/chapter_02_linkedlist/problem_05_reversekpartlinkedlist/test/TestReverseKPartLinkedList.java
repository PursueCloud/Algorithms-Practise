package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_05_reversekpartlinkedlist.test;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_05_reversekpartlinkedlist.impl.ReverseKPartLinkedList;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 反转部分单链表
 */
public class TestReverseKPartLinkedList {

    public static void main(String[] args) {
        SingleNode head = null;
        printLinkedList(head);
        head = ReverseKPartLinkedList.reverseKPartLinkedList(head, 1, 1);
        printLinkedList(head);

        head = new SingleNode(1);
        printLinkedList(head);
        head = ReverseKPartLinkedList.reverseKPartLinkedList(head, 1, 1);
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        printLinkedList(head);
        head = ReverseKPartLinkedList.reverseKPartLinkedList(head, 1, 2);
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        printLinkedList(head);
        head = ReverseKPartLinkedList.reverseKPartLinkedList(head, 2, 3);
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        printLinkedList(head);
        head = ReverseKPartLinkedList.reverseKPartLinkedList(head, 1, 3);
        printLinkedList(head);
    }
}
