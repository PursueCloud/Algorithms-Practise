package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_03_removenodebyratio.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_03_removenodebyratio.impl.RemoveNode.removeMidNode;
import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_03_removenodebyratio.impl.RemoveNode.removeNodeByRatio;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

public class TestRemoveNodeByRatio {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        head.next.next.next.next = new SingleNode(5);
        head.next.next.next.next.next = new SingleNode(6);

        printLinkedList(head);
        SingleNode deleted = removeMidNode(head);
        System.out.println("deleted node : " + deleted);
        printLinkedList(head);
        deleted = removeNodeByRatio(head, 2, 5);
        System.out.println("deleted node : " + deleted);
        printLinkedList(head);
        deleted = removeNodeByRatio(head, 1, 3);
        System.out.println("deleted node : " + deleted);
        printLinkedList(head);
    }
}
