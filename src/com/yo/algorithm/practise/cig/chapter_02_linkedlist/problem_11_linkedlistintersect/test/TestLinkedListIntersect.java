package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_11_linkedlistintersect.test;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_11_linkedlistintersect.impl.LinkedListIntersect;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 测试 - 两个链表相交的一系列问题
 */
public class TestLinkedListIntersect {

    public static void main(String[] args) {
// 1->2->3->4->5->6->7->null
        SingleNode head1 = new SingleNode(1);
        head1.next = new SingleNode(2);
        head1.next.next = new SingleNode(3);
        head1.next.next.next = new SingleNode(4);
        head1.next.next.next.next = new SingleNode(5);
        head1.next.next.next.next.next = new SingleNode(6);
        head1.next.next.next.next.next.next = new SingleNode(7);

        // 0->9->8->6->7->null
        SingleNode head2 = new SingleNode(0);
        head2.next = new SingleNode(9);
        head2.next.next = new SingleNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(LinkedListIntersect.findFirstIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new SingleNode(1);
        head1.next = new SingleNode(2);
        head1.next.next = new SingleNode(3);
        head1.next.next.next = new SingleNode(4);
        head1.next.next.next.next = new SingleNode(5);
        head1.next.next.next.next.next = new SingleNode(6);
        head1.next.next.next.next.next.next = new SingleNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new SingleNode(0);
        head2.next = new SingleNode(9);
        head2.next.next = new SingleNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(LinkedListIntersect.findFirstIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new SingleNode(0);
        head2.next = new SingleNode(9);
        head2.next.next = new SingleNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(LinkedListIntersect.findFirstIntersectNode(head1, head2).value);
    }
}
