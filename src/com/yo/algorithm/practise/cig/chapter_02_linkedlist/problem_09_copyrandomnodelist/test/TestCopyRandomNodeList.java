package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_09_copyrandomnodelist.test;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_09_copyrandomnodelist.impl.entity.RandomNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_09_copyrandomnodelist.impl.CopyRandomNodeList.copyListWithRand1;
import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_09_copyrandomnodelist.impl.CopyRandomNodeList.copyListWithRand2;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printRandLinkedList;

/**
 * 测试 - 复制含有随机指向节点的链表
 */
public class TestCopyRandomNodeList {

    public static void main(String[] args) {
        RandomNode head = null;
        RandomNode res1 = null;
        RandomNode res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new RandomNode(1);
        head.next = new RandomNode(2);
        head.next.next = new RandomNode(3);
        head.next.next.next = new RandomNode(4);
        head.next.next.next.next = new RandomNode(5);
        head.next.next.next.next.next = new RandomNode(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");
    }
}
