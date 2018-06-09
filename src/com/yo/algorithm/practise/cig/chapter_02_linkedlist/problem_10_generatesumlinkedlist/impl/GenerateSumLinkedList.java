package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_10_generatesumlinkedlist.impl;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_04_reverselinkedlist.impl.ReverseLinkedList;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import java.util.Stack;

/**
 * 两个单链表生成相加链表
 */
public class GenerateSumLinkedList {

    /**
     * 时间复杂度：O(N)，额外空间复杂度：O(N)（因为用到了栈）
     * @param head1
     * @param head2
     * @return
     */
    public static SingleNode addLists1(SingleNode head1, SingleNode head2) {
        if (head1==null || head2==null) {
            return null;
        }
        //将链表1、2每个节点的值分别压入每一个栈中
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.value);
            head2 = head2.next;
        }
        //进位
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        SingleNode node = null;
        SingleNode pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            //保存上一个节点
            pre = node;
            //根据求和新增节点
            node = new SingleNode(n % 10);
            //新增节点指向上一节点
            node.next = pre;
            //求进制
            ca = n / 10;
        }
        //如果最后一个位置进制为1，则还要新增一个节点
        if (ca == 1) {
            pre = node;
            node = new SingleNode(1);
            node.next = pre;
        }
        return node;
    }

    public static SingleNode addLists2(SingleNode head1, SingleNode head2) {
        if (head1==null || head2==null) {
            return null;
        }
        //反转两个链表
        head1 = ReverseLinkedList.reverseList(head1);
        head2 = ReverseLinkedList.reverseList(head2);

        //进位
        int ca = 0;
        int n = 0;
        int n1 = 0;
        int n2 = 0;
        SingleNode rHead1 = head1;
        SingleNode rHead2 = head2;
        SingleNode pre = null;
        SingleNode node = null;
        while (rHead1!=null || rHead2!=null) {
            n1 = rHead1 !=null ? rHead1.value : 0;
            n2 = rHead2 !=null ? rHead2.value : 0;
            n = n1 + n2 + ca;
            //保存上一个节点
            pre = node;
            //根据求和生成新节点
            node = new SingleNode(n % 10);
            //新节点指向上一个节点
            node.next = pre;
            //求进制
            ca = n / 10;
            //两个反转后的链表指针同步往下移动
            rHead1 = rHead1 !=null ? rHead1.next : null;
            rHead2 = rHead2 !=null ? rHead2.next : null;
        }
        //如果最后一个位置进制为1，则还要新增一个节点
        if (ca == 1) {
            pre = node;
            node = new SingleNode(1);
            node.next = pre;
        }
        //恢复链表1、2
        ReverseLinkedList.reverseList(head1);
        ReverseLinkedList.reverseList(head2);
        return node;
    }
}
