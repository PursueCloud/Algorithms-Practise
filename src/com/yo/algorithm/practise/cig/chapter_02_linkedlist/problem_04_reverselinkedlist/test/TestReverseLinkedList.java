package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_04_reverselinkedlist.test;

import com.yo.algorithm.practise.cig.common.entity.DoubleNode;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_04_reverselinkedlist.impl.ReverseLinkedList.reverseLinkedList;
import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_04_reverselinkedlist.impl.ReverseLinkedList.reverseList;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 反转链表-测试
 */
public class TestReverseLinkedList {

    public static void main(String[] args) {
        SingleNode head1 = new SingleNode(1);
        head1.next = new SingleNode(2);
        head1.next.next = new SingleNode(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
//        head1 = reverseLinkedList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printLinkedList(head2);
        printLinkedList(reverseList(head2));
//        printLinkedList(reverseLinkedList(head2));
    }
}
