package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_19_mergetwosortedlist.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_19_mergetwosortedlist.impl.MergeTwoSortedList.merge;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 测试 - 合并两个有序链表
 */
public class TestMergeTwoSortedList {

    public static void main(String[] args) {
        SingleNode head1 = null;
        SingleNode head2 = null;
        System.out.print("linked list 1: ");
        printLinkedList(head1);
        System.out.print("linked list 2: ");
        printLinkedList(head2);
        SingleNode head = merge(head1, head2);
        System.out.print("merged : ");
        printLinkedList(head);

        head1 = new SingleNode(1);
        head2 = null;
        System.out.print("linked list 1: ");
        printLinkedList(head1);
        System.out.print("linked list 2: ");
        printLinkedList(head2);
        head = merge(head1, head2);
        System.out.print("merged : ");
        printLinkedList(head);

        head1 = null;
        head2 = new SingleNode(1);
        System.out.print("linked list 1: ");
        printLinkedList(head1);
        System.out.print("linked list 2: ");
        printLinkedList(head2);
        head = merge(head1, head2);
        System.out.print("merged : ");
        printLinkedList(head);

        head1 = new SingleNode(1);
        head2 = new SingleNode(2);
        System.out.print("linked list 1: ");
        printLinkedList(head1);
        System.out.print("linked list 2: ");
        printLinkedList(head2);
        head = merge(head1, head2);
        System.out.print("merged : ");
        printLinkedList(head);

        head1 = new SingleNode(2);
        head2 = new SingleNode(1);
        System.out.print("linked list 1: ");
        printLinkedList(head1);
        System.out.print("linked list 2: ");
        printLinkedList(head2);
        head = merge(head1, head2);
        System.out.print("merged : ");
        printLinkedList(head);

        head1 = new SingleNode(1);
        head1.next = new SingleNode(4);
        head2 = new SingleNode(2);
        head2.next = new SingleNode(3);
        head2.next.next = new SingleNode(5);
        System.out.print("linked list 1: ");
        printLinkedList(head1);
        System.out.print("linked list 2: ");
        printLinkedList(head2);
        head = merge(head1, head2);
        System.out.print("merged : ");
        printLinkedList(head);

        head1 = new SingleNode(1);
        head1.next = new SingleNode(3);
        head1.next.next = new SingleNode(5);
        head1.next.next.next = new SingleNode(7);
        head1.next.next.next.next = new SingleNode(9);
        head2 = new SingleNode(0);
        head2.next = new SingleNode(6);
        head2.next.next = new SingleNode(6);
        head2.next.next.next = new SingleNode(7);
        System.out.print("linked list 1: ");
        printLinkedList(head1);
        System.out.print("linked list 2: ");
        printLinkedList(head2);
        head = merge(head1, head2);
        System.out.print("merged : ");
        printLinkedList(head);
    }
}
