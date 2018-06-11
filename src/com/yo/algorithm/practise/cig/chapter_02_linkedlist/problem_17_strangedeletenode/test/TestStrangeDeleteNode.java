package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_17_strangedeletenode.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_17_strangedeletenode.impl.StrangeDeleteNode.deleteNodeWired;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 测试 - 一种怪异的节点删除方式
 */
public class TestStrangeDeleteNode {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        SingleNode node = head;
        printLinkedList(head);
        deleteNodeWired(node);
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        node = head.next;
        printLinkedList(head);
        deleteNodeWired(node);
        printLinkedList(head);

		head = new SingleNode(1);
		head.next = new SingleNode(2);
		head.next.next = new SingleNode(3);
		node = head.next.next;
		printLinkedList(head);
		deleteNodeWired(node);
		printLinkedList(head);
    }
}
