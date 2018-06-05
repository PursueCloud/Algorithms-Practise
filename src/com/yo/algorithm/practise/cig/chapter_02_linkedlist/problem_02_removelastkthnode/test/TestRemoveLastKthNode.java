package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_02_removelastkthnode.test;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_02_removelastkthnode.impl.RemoveLastKthNode;
import com.yo.algorithm.practise.cig.common.entity.DoubleNode;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;
import com.yo.algorithm.practise.cig.common.util.LinkedListUtil;

import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

public class TestRemoveLastKthNode {

    /**
     * 测试-删除链表倒数第k个节点
     * 结果：
     *      Linked List: 1 2 3 4 5 6
     *      Linked List: 1 2 3 5 6
     *      Double Linked List: 1 2 3 4 5 6 | 6 5 4 3 2 1
     *      Double Linked List: 1 2 3 5 6 | 6 5 3 2 1
     * @param args
     */
    public static void main(String[] args) {
        SingleNode head1 = new SingleNode(1);
        head1.next = new SingleNode(2);
        head1.next.next = new SingleNode(3);
        head1.next.next.next = new SingleNode(4);
        head1.next.next.next.next = new SingleNode(5);
        head1.next.next.next.next.next = new SingleNode(6);
        LinkedListUtil.printLinkedList(head1);
        head1 = RemoveLastKthNode.removeLastKthNode(head1, 3);
        // head1 = removeLastKthNode(head1, 6);
        // head1 = removeLastKthNode(head1, 7);
        LinkedListUtil.printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        head2.next.next.next.next = new DoubleNode(5);
        head2.next.next.next.next.last = head2.next.next.next;
        head2.next.next.next.next.next = new DoubleNode(6);
        head2.next.next.next.next.next.last = head2.next.next.next.next;
        printLinkedList(head2);
        head2 = RemoveLastKthNode.removeLastKthNode(head2, 3);
        // head2 = removeLastKthNode(head2, 6);
        // head2 = removeLastKthNode(head2, 7);
        printLinkedList(head2);

    }
}
