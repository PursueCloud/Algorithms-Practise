package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_18_insertnodetosortedlooplinkedlist.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_18_insertnodetosortedlooplinkedlist.impl.InsertNodeToSortedLoopLinkedList.insertNum;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printCircularList;

/**
 * 测试 - 向有序的环形单链表中插入新节点
 */
public class TestInsertNodeToSortLoopLinkedList {

    public static void main(String[] args) {
        SingleNode head = null;
        head = insertNum(head, 2);
        printCircularList(head);
        head = insertNum(head, 1);
        printCircularList(head);
        head = insertNum(head, 4);
        printCircularList(head);
        head = insertNum(head, 3);
        printCircularList(head);
        head = insertNum(head, 5);
        printCircularList(head);
        head = insertNum(head, 0);
        printCircularList(head);
    }
}
