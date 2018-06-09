package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_11_linkedlistintersect.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 两个链表相交的一系列问题：
 *    在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点head1和head2，这两个链表可能相交，也可能不相交。
 *    请实现一个函数，如果两个链表相交，请相交的第一个节点；如果不相交，返回null即可。
 *    要求：如果链表1的长度为N，链表2的长度为M，时间复杂请达到O(N+M），额外空间复杂度请达到O(1）
 * 分析：
 *      这道题可以拆分成三个子问题，每个问题都可以作为一道独立的算法题，具体如下：
 *          ①如何判断一个链表是否有环，如果有，则返回第一个进入环的节点，没有则返回null
 *          ②如果判断两个无环链表是否相交，相交则返回第一个相交节点，不相交则返回null
 *          ②如果判断两个有环链表是否相交，相交则返回第一个相交节点，不相交则返回null
 *      注意：如果一个链表有环，另外一个链表无环，它们是不可能相交的(因为如果其中一个链表有环，
 *      另一个链表无环，当它们相交时，另一个链表必定是有环的，而这与描述相悖，所以有环链表与无环链表不可能相交)，直接返回null
 */
public class LinkedListIntersect {

    /**
     * 找到两个链表相交的第一个节点
     * @param head1
     * @param head2
     * @return
     */
    public static SingleNode findFirstIntersectNode(SingleNode head1, SingleNode head2) {
        //其中一个链表为空，则表示两链表不相交
        if (head1==null || head2==null) {
            return null;
        }
        SingleNode loop1 = getLoopNode(head1);
        SingleNode loop2 = getLoopNode(head2);
        if (loop1!=null && loop2!=null) {
            //两个链表都有环时
            return getBothLoopIntersect(head1, loop1, head2, loop2);
        } else if (loop1!=null || loop2!=null) {
            //其中一个有环，另一个无环，则两个链表一定不相交，故返回空
            return null;
        } else {
            return getNoLoopIntersect(head1, head2);
        }
    }

    /**
     * 返回指定链表入环的第一个节点，如果该链表无环，则返回null
     * @param head
     * @return
     */
    public static SingleNode getLoopNode(SingleNode head) {
        if (head==null || head.next==null || head.next.next==null) {
            return null;
        }
        SingleNode slow = head.next;
        SingleNode fast = head.next.next;
        //fast指针和slow指针第一次相遇时退出循环
        while (fast != slow) {
            //如果快指针遍历到的链表尾部（即下一个节点或下下个节点为空时）
            if (fast.next==null || fast.next.next==null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //fast指针从头开始跑
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static SingleNode getNoLoopIntersect(SingleNode head1, SingleNode head2) {
        //其中一个链表为空，则表示两链表不相交
        if (head1==null || head2==null) {
            return null;
        }
        SingleNode curr1 = head1;
        SingleNode curr2 = head2;
        int n = 0;
        while (curr1.next != null) {
            n++;
            curr1 = curr1.next;
        }
        while (curr2.next != null) {
            n--;
            curr2 = curr2.next;
        }
        if (curr1 != curr2) {
            return null;
        }
        curr1 = n > 0 ? head1 : head2;
        curr2 = curr1 == head1 ? head2 : head1;
        n = Math.abs(n);
        //让比较长的链表先走n步
        while (n != 0) {
            n--;
            curr1 = curr1.next;
        }
        //然后两个链表同时往下移动
        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
    }

    public static SingleNode getBothLoopIntersect(SingleNode head1, SingleNode loop1,
                                                  SingleNode head2, SingleNode loop2) {
        SingleNode curr1 = null;
        SingleNode curr2 = null;
        if (loop1 == loop2) {
            curr1 = head1;
            curr2 = head2;
            int n = 0;
            while (curr1 != loop1) {
                n++;
                curr1 = curr1.next;
            }
            while (curr2 != loop2) {
                n--;
                curr2 = curr2.next;
            }
            curr1 = n > 0 ? head1 : head2;
            curr2 = curr1==head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                curr1 = curr1.next;
            }
            while (curr1 != curr2) {
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            return curr1;
        } else {
            curr1 = loop1.next;
            while (curr1 != loop1) {
                if (curr1 == loop2) {
                    return loop1;
                }
                curr1 = curr1.next;
            }
            return null;
        }
    }
}
