package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_05_reversekpartlinkedlist.impl;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_04_reverselinkedlist.impl.ReverseLinkedList;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 反转部分单向链表
 */
public class ReverseKPartLinkedList {

    public static SingleNode reverseKPartLinkedList(SingleNode head, int from, int to) {
        if (head == null) {
            return null;
        }
        int n = 0;
        //from位置前面的节点
        SingleNode fPre = null;
        //to位置后面的节点
        SingleNode tPos = null;
        //待反转部分的开始节点
        SingleNode fromNode = null;
        //待反转部分的结束节点
        SingleNode toNode = null;
        //找到fPre和tPos节点以及链表长度
        SingleNode curr = head;
        while (curr != null) {
            n++;
            fPre = n == from-1 ? curr : fPre;
            toNode = n == to ? curr : toNode;
            curr = curr.next;
        }
        //不符合1 <= from <= to <= n
        if (1>from  || from > to || to > n) {
            return head;
        }
        tPos = toNode.next;
        //断开结束节点与下一节点的连接
        toNode.next = null;

        if (fPre == null) {
            //fPre为空时，表示待反转部分的开始节点就是头节点，反转之后的新的头结点为待反转部分的结束节点
            fromNode = head;
            //反转
            ReverseLinkedList.reverseList(fromNode);
            //将反转之后的链表的尾部与原链表连接起来
            fromNode.next = tPos;

            //返回新的头节点
            return toNode;
        } else {
            //fPre不为空时，待反转部分的开始节点在头节点之后，反转之后的新的头节点为原头节点
            fromNode = fPre.next;
            //反转
            ReverseLinkedList.reverseList(fromNode);
            //将反转之后的链表的头部尾部与原链表连接起来
            fPre.next = toNode;
            fromNode.next = tPos;

            //返回新的头节点
            return head;
        }
    }
}
