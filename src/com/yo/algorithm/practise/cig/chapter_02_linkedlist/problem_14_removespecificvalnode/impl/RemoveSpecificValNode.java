package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_14_removespecificvalnode.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 删除单链表中指定值的节点
 */
public class RemoveSpecificValNode {

    /**
     * 时间复杂度：O(N)，额外空间复杂度：O(N)。最优解
     * @param head
     * @param val
     * @return
     */
    public static SingleNode removeSpecificValNode(SingleNode head, int val) {
        if (head == null) {
            return head;
        }
        SingleNode curr = head;
        SingleNode pre = null;
        while (curr != null) {
            if (curr.value == val) {
                if (curr == head) {
                    head = head.next;
                } else {
                    pre.next = curr.next;
                }
            } else {
                pre = curr;
            }
            curr = curr.next;
        }

        return head;
    }
    public static SingleNode removeSpecificValNode_useQueue(SingleNode head, int val) {
        if (head == null) {
            return head;
        }
        LinkedList<SingleNode> queue = new LinkedList<>();
        //将所有值不等于val的节点添加到队列中
        SingleNode curr = head;
        while (curr != null) {
            if (curr.value != val) {
                queue.add(curr);
            }
            curr = curr.next;
        }
        //将队列中所有节点按顺序连接起来
        SingleNode newHead = queue.poll();
        curr = newHead;
        SingleNode next = null;
        while (!queue.isEmpty()) {
            next = queue.poll();
            next.next = null;
            curr.next = next;
            curr = next;
        }

        return newHead;
    }
    public static SingleNode removeSpecificValNode_useStack(SingleNode head, int val) {
        Stack<SingleNode> stack = new Stack<>();
        while (head != null) {
            if (head.value != val) {
                stack.push(head);
            }
            head = head.next;
        }
        //将栈中的所有节点一次弹出，并将每个节点指向其上一次弹出的节点
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }

        return head;
    }
}
