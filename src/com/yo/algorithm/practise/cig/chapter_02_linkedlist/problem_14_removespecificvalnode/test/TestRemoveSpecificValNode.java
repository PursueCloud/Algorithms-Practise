package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_14_removespecificvalnode.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_14_removespecificvalnode.impl.RemoveSpecificValNode.removeSpecificValNode;
import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_14_removespecificvalnode.impl.RemoveSpecificValNode.removeSpecificValNode_useQueue;
import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_14_removespecificvalnode.impl.RemoveSpecificValNode.removeSpecificValNode_useStack;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 测试 - 删除单链表中指定值的节点
 */
public class TestRemoveSpecificValNode {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(1);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(3);
        head.next.next.next.next = new SingleNode(1);
        head.next.next.next.next.next = new SingleNode(2);
        head.next.next.next.next.next.next = new SingleNode(1);
        head.next.next.next.next.next.next.next = new SingleNode(1);
        printLinkedList(head);
        head = removeSpecificValNode(head, 1);
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(1);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(3);
        head.next.next.next.next = new SingleNode(1);
        head.next.next.next.next.next = new SingleNode(2);
        head.next.next.next.next.next.next = new SingleNode(1);
        head.next.next.next.next.next.next.next = new SingleNode(1);
        printLinkedList(head);
        head = removeSpecificValNode_useStack(head, 1);
        printLinkedList(head);
    }
}
