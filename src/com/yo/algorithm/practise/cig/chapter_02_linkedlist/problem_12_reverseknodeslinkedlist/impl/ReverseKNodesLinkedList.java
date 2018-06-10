package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_12_reverseknodeslinkedlist.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import java.util.Stack;

/**
 * 反转链表中的每k个节点
 */
public class ReverseKNodesLinkedList {



    /**
     * 时间复杂度：O(N)，额外空间复杂度：O(N)，因为用到了栈
     * @param head
     * @param k
     * @return
     */
    public static SingleNode reverseKNodes1(SingleNode head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<SingleNode> stack = new Stack<SingleNode>();
        SingleNode curr = head;
        SingleNode newHead = head;
        SingleNode pre = null;
        SingleNode next = null;

        while (curr != null) {
            next = curr.next;
            //将当前节点压入栈中
            stack.push(curr);
            if (stack.size() == k) {
                //当栈中元素个数达到k个时，对栈中元素进行调整（从栈顶往栈底逆序），并将逆序后的最后一个节点更新到pre引用
                pre = resign1(stack, pre, next);
                //将第一次调整后的节点（即第一次逆序调整之前k部分最后一个节点）作为所有逆序调整完成后链表的头节点
                newHead = newHead==head ? curr : newHead;
            }
            curr = next;
        }

        return newHead;
    }
    private static SingleNode resign1(Stack<SingleNode> stack, SingleNode left, SingleNode right) {
        SingleNode curr = stack.pop();
        if (left != null) {
            //将待反转部分与前面的节点连接起来1
            left.next = curr;
        }
        SingleNode next = null;
        //以相反的顺序连接栈中剩下的节点
        while (!stack.isEmpty()) {
            next = stack.pop();
            curr.next = next;
            curr = next;
        }
        //将反转完成的部分与后面的节点连接起来
        curr.next = right;

        return curr;
    }

    /**
     * 时间复杂度：O(N)，额外空间复杂度：O(1)，最优解
     * @param head
     * @param k
     * @return
     */
    public static SingleNode reverseKNodes2(SingleNode head, int k) {
        if (k < 2) {
            return head;
        }
        SingleNode curr = head;
        SingleNode start = null;
        SingleNode pre = null;
        SingleNode next = null;
        int count = 1;
        while (curr != null) {
            next = curr.next;
            if (count == k) {
                start = pre==null ? head : pre.next;
                head = pre==null ? curr : head;
                resign2(pre, start, curr, next);
                pre = start;
                count = 0;
            }
            count++;
            curr = next;
        }

        return head;
    }
    public static void resign2(SingleNode left, SingleNode start, SingleNode end, SingleNode right) {
        SingleNode pre = start;
        SingleNode curr = start.next;
        SingleNode next = null;
        //反转start节点到end节点之间的部分
        while (curr != right) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        //将反转之后的头节点（即反转之前的尾节点）与前面的节点连接起来
        if (left != null) {
            left.next = end;
        }
        //将反转之后的尾节点（即反转之前的头结点）与后面的节点连接起来
        start.next = right;
    }
}
