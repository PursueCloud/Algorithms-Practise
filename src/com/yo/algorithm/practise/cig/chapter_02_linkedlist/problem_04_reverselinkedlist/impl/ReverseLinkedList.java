package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_04_reverselinkedlist.impl;

import com.yo.algorithm.practise.cig.common.entity.DoubleNode;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 反转单链表和双链表
 * 思路：
 *      从前往后，将旧链表的节点指向新链表的头节点
 */
public class ReverseLinkedList {

/**
 * 示例
 * 1-2-3 逆序过程如下：
 *      1 2-3
 *      2-1 3
 *      3-2-1
 * 1-2-3-4-5 逆序过程如下：
 *     1-2-3-4-5
 *     1 2-3-4-5
 *     2-1 3-4-5
 *     3-2-1 4-5
 *     4-3-2-3 5
 *     5-4-3-2-1
 */
    /**
     * 反转单(向)链表
     * @param head
     * @return
     */
    public static SingleNode reverseLinkedList(SingleNode head) {
        SingleNode pre = null;
        SingleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
//理解
    public static SingleNode reverseList(SingleNode head) {
        //新链表头节点
        SingleNode newHead = null;
        SingleNode next = null;

        //当前遍历的节点
        SingleNode curr = head;
        while (curr != null) {
            //将当前节点的下一个节点往后移动一个节点
            next = curr.next;
            //将当前节点指向新链表头节点
            curr.next = newHead;
            //将新链表头节点往前移动一个节点，即指向到刚刚添加的curr节点上
            newHead = curr;
            //当前遍历节点往后移动一个节点，即移动到next节点上
            curr = next;
        }

        return newHead;
    }
    public static DoubleNode reverseList(DoubleNode head) {
        //新链表头节点
        DoubleNode newHead = null;
        DoubleNode next = null;

        //当前遍历的节点
        DoubleNode curr = head;
        while (curr != null) {
            //将当前节点的下一个节点往后移动一个节点
            next = curr.next;
            //将当前节点的next指针指向新链表头节点
            curr.next = newHead;
            //将当前节点的last指针指向下一个节点，因为是逆序，所以新链表中节点的前置节点即是旧链表中该节点的后置节点
            curr.last = next;
            //将新链表头节点往前移动一个节点，即指向到刚刚添加的curr节点上
            newHead = curr;
            //当前遍历节点往后移动一个节点，即移动到next节点上
            curr = next;
        }

        return newHead;
    }
}
