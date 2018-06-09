package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_06_josephusproblem.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_06_josephusproblem.impl.JosephusProblem.josephusKill;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printCircularList;

/**
 * 测试 - 单向换线链表的约瑟夫问题
 */
public class TestJosephusProblem {

    public static void main(String[] args) {
        SingleNode head1 = new SingleNode(1);
        head1.next = new SingleNode(2);
        head1.next.next = new SingleNode(3);
        head1.next.next.next = new SingleNode(4);
        head1.next.next.next.next = new SingleNode(5);
        head1.next.next.next.next.next = head1;
        printCircularList(head1);
        head1 = josephusKill(head1, 3);
        printCircularList(head1);

        SingleNode head2 = new SingleNode(1);
        head2.next = new SingleNode(2);
        head2.next.next = new SingleNode(3);
        head2.next.next.next = new SingleNode(4);
        head2.next.next.next.next = new SingleNode(5);
        head2.next.next.next.next.next = head2;
        printCircularList(head2);
        head2 = josephusKill(head2, 3);
        printCircularList(head2);
    }
}
