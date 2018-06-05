package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_01_linkedlistcommonpart.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_01_linkedlistcommonpart.impl.PrintCommonPart.printCommonPart;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 打印两个有序链表的公共部分-测试
 */
public class TestPrintCommonPart {

    /**
     * 测试结果：
     *          Linked List: 2 3 5 6
     *          Linked List: 1 2 5 7 8
     *          Common part:
     *          2 5
     * @param args
     */
    public static void main(String[] args) {
        SingleNode node1 = new SingleNode(2);
        node1.next = new SingleNode(3);
        node1.next.next = new SingleNode(5);
        node1.next.next.next = new SingleNode(6);

        SingleNode node2 = new SingleNode(1);
        node2.next = new SingleNode(2);
        node2.next.next = new SingleNode(5);
        node2.next.next.next = new SingleNode(7);
        node2.next.next.next.next = new SingleNode(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);
    }
}
