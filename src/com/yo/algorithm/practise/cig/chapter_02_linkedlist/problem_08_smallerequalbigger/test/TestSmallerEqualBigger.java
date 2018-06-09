package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_08_smallerequalbigger.test;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_08_smallerequalbigger.impl.SmallerEqualBigger;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 测试 - 将单向链表按某值划分为左边小、总结相等、右边大的形式
 */
public class TestSmallerEqualBigger {

    public static void main(String[] args) {
        SingleNode head1 = new SingleNode(7);
        head1.next = new SingleNode(9);
        head1.next.next = new SingleNode(1);
        head1.next.next.next = new SingleNode(8);
        head1.next.next.next.next = new SingleNode(2);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = SmallerEqualBigger.listPartition(head1, 5);
        printLinkedList(head1);

        head1 = new SingleNode(7);
        head1.next = new SingleNode(9);
        head1.next.next = new SingleNode(1);
        head1.next.next.next = new SingleNode(8);
        head1.next.next.next.next = new SingleNode(5);
        head1.next.next.next.next.next = new SingleNode(2);
        head1.next.next.next.next.next.next = new SingleNode(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = SmallerEqualBigger.listPartition(head1, 5);
        printLinkedList(head1);
    }
}
