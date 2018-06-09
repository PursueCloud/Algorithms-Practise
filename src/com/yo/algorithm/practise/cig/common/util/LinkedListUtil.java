package com.yo.algorithm.practise.cig.common.util;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_09_copyrandomnodelist.impl.entity.RandomNode;
import com.yo.algorithm.practise.cig.common.entity.DoubleNode;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;

public class LinkedListUtil {

    /**
     * 打印单遍历
     * @param node
     */
    public static void printLinkedList(SingleNode node) {
        System.out.print("Single Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 打印双链表
     * @param head
     */
    public static void printLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    /**
     * 打印环形单链表
     * @param head
     */
    public static void printCircularList(SingleNode head) {
        if (head == null) {
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        SingleNode cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }

    /**
     * 打印含有随机指针节点的链表
     * @param head
     */
    public static void printRandLinkedList(RandomNode head) {
        RandomNode cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
