package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_10_generatesumlinkedlist.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_10_generatesumlinkedlist.impl.GenerateSumLinkedList.addLists1;
import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_10_generatesumlinkedlist.impl.GenerateSumLinkedList.addLists2;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 生成两个链表相加的链表
 */
public class TestGenerateSumLinkedList {

    public static void main(String[] args) {
        SingleNode head1 = new SingleNode(9);
        head1.next = new SingleNode(9);
        head1.next.next = new SingleNode(9);

        SingleNode head2 = new SingleNode(1);

        printLinkedList(head1);
        printLinkedList(head2);
        printLinkedList(addLists1(head1, head2));
        printLinkedList(addLists2(head1, head2));
    }
}
