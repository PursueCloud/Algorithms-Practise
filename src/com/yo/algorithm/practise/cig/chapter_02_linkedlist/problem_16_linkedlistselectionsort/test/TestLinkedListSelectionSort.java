package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_16_linkedlistselectionsort.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_16_linkedlistselectionsort.impl.LinkedListSelectionSort.selectionSort;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 测试 - 单链表的选择排序
 */
public class TestLinkedListSelectionSort {

    public static void main(String[] args) {
        SingleNode head = null;
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(1);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(2);
        head.next = new SingleNode(1);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(3);
        head.next.next = new SingleNode(2);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(2);
        head.next = new SingleNode(1);
        head.next.next = new SingleNode(3);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(2);
        head.next = new SingleNode(3);
        head.next.next = new SingleNode(1);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(3);
        head.next = new SingleNode(1);
        head.next.next = new SingleNode(2);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(3);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(1);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);

        head = new SingleNode(3);
        head.next = new SingleNode(1);
        head.next.next = new SingleNode(4);
        head.next.next.next = new SingleNode(2);
        printLinkedList(head);
        head = selectionSort(head);
        printLinkedList(head);
    }
}
