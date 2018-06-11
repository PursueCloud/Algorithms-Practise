package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_18_insertnodetosortedlooplinkedlist.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 向有序的环形单链表中插入新节点
 */
public class InsertNodeToSortedLoopLinkedList {

    public static SingleNode insertNum(SingleNode head, int num) {
        SingleNode newNode = new SingleNode(num);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        SingleNode pre = head;
        SingleNode curr = head.next;
        //从头到尾遍历链表
        while (curr != head) {
            //如果num在当前节点的前一个节点的值与当前节点的值之间，则往pre和curr之间插入新节点，并跳出循环
            if (pre.value<=num && curr.value>=num) {
                break;
            }
            pre = curr;
            curr = curr.next;
        }
        // 1、如果num的值在pre和curr的值之间，则将新节点插入到pre和curr之间，此时pre和curr在头结点和为节点之间
        // 2、如果遍历完整个链表后newNode都未成功插入，则表示num的值比头节点小或比尾节点值大，则将新节点插入到尾节点和头节点之间，而此时pre和curr刚好就是尾节点和头节点
        pre.next = newNode;
        newNode.next = curr;
        //判断当前头节点值是否比num小，如果是，头节点不变；否则，新插入节点即为链表的新的头节点
        return head.value < num ? head : newNode;
    }

}
