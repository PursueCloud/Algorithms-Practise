package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_13_removeduplicatevalnode.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_13_removeduplicatevalnode.impl.RemoveDuplicateValNode.removeDuplicateValNode1;
import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_13_removeduplicatevalnode.impl.RemoveDuplicateValNode.removeDuplicateValNode2;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 测试 - 删除无序单链表中值重复出现的节点
 */
public class TestRemoveDuplicateValNode {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(3);
        head.next.next.next.next = new SingleNode(4);
        head.next.next.next.next.next = new SingleNode(4);
        head.next.next.next.next.next.next = new SingleNode(2);
        head.next.next.next.next.next.next.next = new SingleNode(1);
        head.next.next.next.next.next.next.next.next = new SingleNode(1);
        printLinkedList(head);
        removeDuplicateValNode2(head);
        printLinkedList(head);

        head = new SingleNode(1);
        head.next = new SingleNode(1);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(3);
        head.next.next.next.next = new SingleNode(4);
        head.next.next.next.next.next = new SingleNode(4);
        head.next.next.next.next.next.next = new SingleNode(2);
        head.next.next.next.next.next.next.next = new SingleNode(1);
        head.next.next.next.next.next.next.next.next = new SingleNode(1);
        printLinkedList(head);
        removeDuplicateValNode2(head);
        printLinkedList(head);
    }
}
