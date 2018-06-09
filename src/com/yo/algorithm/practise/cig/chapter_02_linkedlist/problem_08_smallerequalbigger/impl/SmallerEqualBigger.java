package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_08_smallerequalbigger.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 将单向链表按某值划分为左边小、总结相等、右边大的形式
 */
public class SmallerEqualBigger {

    public static SingleNode listPartition(SingleNode head, int pivot) {
        if (head == null) {
            return head;
        }
        SingleNode smaller = null;
        SingleNode equal = null;
        SingleNode bigger = null;

        SingleNode sHead = null;
        SingleNode eHead = null;
        SingleNode bHead = null;

        SingleNode next = null;
        while (head != null) {
            //保存下一节点
            next = head.next;
            //断开当前节点与下一节点的连接
            head.next = null;
            if (head.value < pivot) {
                if (smaller == null) {
                    smaller = head;
                    sHead = head;
                } else {
                    smaller.next = head;
                    smaller = smaller.next;
                }
            } else if (head.value == pivot) {
                if (equal == null) {
                    equal = head;
                    eHead = head;
                } else {
                    equal.next = head;
                    equal = equal.next;
                }
            } else {
                if (bigger == null) {
                    bigger = head;
                    bHead = head;
                } else {
                    bigger.next = head;
                    bigger = bigger.next;
                }
            }
            //移动到下一节点
            head = next;
        }
        if (smaller != null) {
            smaller.next = eHead!=null ? eHead : bHead;
        }
        if (equal != null) {
            equal.next = bHead;
        }

        return sHead!=null ? sHead : eHead !=null ? eHead : bHead;
    }
}
