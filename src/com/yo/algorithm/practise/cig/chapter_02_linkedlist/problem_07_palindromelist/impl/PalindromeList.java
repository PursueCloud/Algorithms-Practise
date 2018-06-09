package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_07_palindromelist.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import java.util.Stack;

/**
 * 判断单链表是否为回文结构
 */
public class PalindromeList {

    /**
     * 最佳解法
     * 时间复杂度O(N)，额外空间复杂度O(1)
     * @param head
     * @return
     */
    public static boolean isPalindrome3(SingleNode head) {
        if (head==null || head.next==null) {
            return true;
        }
        SingleNode n1 = head;
        SingleNode n2 = head;
        //查找中间节点(n1保存中间节点)
        while (n2.next!=null && n2.next.next!=null) {
            //n1 -> 中部
            n1 = n1.next;
            //n2 -> 结尾
            n2 = n2.next.next;
        }
        // n2保存中间节点的下一个节点，即右半区的第一个节点
        n2 = n1.next;
        // 断开左半区与右半区的连接
        n1.next = null;
        SingleNode n3 = null;
        // 右半区链表反转
        while (n2 != null) {
            // n3 -> 保存下一个节点
            n3 = n2.next;
            // 下一个反转节点
            n2.next = n1;
            // n1移动
            n1 = n2;
            // n2移动
            n2 = n3;
        }
        // n3 -> 保存最后一个节点，即右半区反转后的第一个节点
        n3 = n1;
        // n2 -> 左边第一个节点
        n2 = head;
        boolean result = true;
        // 检查回文
        while (n1!=null && n2!=null) {
            if (n1.value != n2.value) {
                result = false;
                break;
            }
            // 从右到中部
            n1 = n1.next;
            // 从左到中部
            n2 = n2.next;
        }
        //n1指向右半区反转后的第二个节点，即最后一个节点的下一节点
        n1 = n3.next;
        //断开右半区反转后第一个节点与第二个节点的连接（因为需要反转），将其（第一个节点）用于再次反转过程的初始头节点
        n3.next = null;
        // 恢复列表(再次反转右半区)
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return result;
    }

    public static boolean isPalindrome_best(SingleNode head) {
        if (head==null || head.next==head) {
            return true;
        }
        SingleNode n1 = head;
        SingleNode n2 = head;
        //找到中间节点
        while (n2.next!=null && n2.next.next!=null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        //n2保存右半区第一个节点，即中间节点n1的下一节点
        n2 = n1.next;
        //断开左半区与右半区的连接，用于将n1当成右半区反转过程的初始头节点
        n1.next = null;
        SingleNode n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        //n3保存右半区反转之后的第一个节点，即原链表的最后一个节点
        n3 = n1;
        //n2保存左半区的第一个节点
        n2 = head;
        // 检查回文
        boolean result = true;
        while (n1!=null && n2!=null) {
            if (n1.value != n2.value) {
                result = false;
                break;
            }
            //从右到中移动
            n1 = n1.next;
            //从左到中移动
            n2 = n2.next;
        }
        //n1保存右半区反转后的第二个节点
        n1 = n3.next;
        //断开反转后的右半区的第一个节点与第二个节点的连接，用于将第一个节点当成再次反转过程的初始头节点
        n3.next = null;
        //恢复右半区（再次反转）
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return result;
    }

    /**
     * 时间复杂度O(N)，额外空间复杂度O(N)
     * @param head
     * @return
     */
    public static boolean isPalindrome1(SingleNode head) {
        if (head==null || head.next==null) {
            return true;
        }
        Stack<SingleNode> stack = new Stack<>();
        SingleNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    /**1 1 1 1
     * 时间复杂度O(N)，额外空间复杂度O(N/2)
     * @param head
     * @return
     */
    public static boolean isPalindrome2(SingleNode head) {
        if (head==null || head.next==null) {
            return true;
        }
        SingleNode right = head.next;
        SingleNode curr = head;
        while (curr.next!=null && curr.next.next!=null) {
            //right每次移1步
            right = right.next;
            //curr每次移2步
            curr = curr.next.next;
        }
        Stack<SingleNode> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
