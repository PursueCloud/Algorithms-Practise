package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_01_linkedlistcommonpart.test;

import com.yo.algorithm.practise.cig.common.entity.Node;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_01_linkedlistcommonpart.impl.PrintCommonPart.printCommonPart;

/**
 * 打印两个有序链表的公共部分-测试
 */
public class TestPrintCommonPart {
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 测试结果：
     *          Linked List: 2 3 5 6
     *          Linked List: 1 2 5 7 8
     *          Common part:
     *          2 5
     * @param args
     */
    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);
    }
}
