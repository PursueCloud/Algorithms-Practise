package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_20_recombinelinkedlist.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_20_recombinelinkedlist.impl.RecombineLinkedList.recombine;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 测试 - 按照左右半区的方式重新组合单链表
 */
public class TestRecombineLinkedList {

    public static void main(String[] args) {
        SingleNode head = null;
        System.out.println("before recombining : ");
        printLinkedList(head);
        recombine(head);
        System.out.println("after recombining : ");
        printLinkedList(head);

        head = new SingleNode(1);
        System.out.println("before recombining : ");
        printLinkedList(head);
        recombine(head);
        System.out.println("after recombining : ");
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        System.out.println("before recombining : ");
        printLinkedList(head);
        recombine(head);
        System.out.println("after recombining : ");
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        System.out.println("before recombining : ");
        printLinkedList(head);
        recombine(head);
        System.out.println("after recombining : ");
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        System.out.println("before recombining : ");
        printLinkedList(head);
        recombine(head);
        System.out.println("after recombining : ");
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        head.next.next.next.next = new SingleNode(5);
        System.out.println("before recombining : ");
        printLinkedList(head);
        recombine(head);
        System.out.println("after recombining : ");
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        head.next.next.next.next = new SingleNode(5);
        head.next.next.next.next.next = new SingleNode(6);
        System.out.println("before recombining : ");
        printLinkedList(head);
        recombine(head);
        System.out.println("after recombining : ");
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        head.next.next.next.next = new SingleNode(5);
        head.next.next.next.next.next = new SingleNode(6);
        head.next.next.next.next.next.next = new SingleNode(7);
        System.out.println("before recombining : ");
        printLinkedList(head);
        recombine(head);
        System.out.println("after recombining : ");
        printLinkedList(head);
    }
}
