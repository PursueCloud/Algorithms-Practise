package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_01_linkedlistcommonpart.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 打印两个有序链表的公共部分
 * 思路：
 *      如果head1的值小于head2，则head1往下移动
 *      如果head2的值小于head1，则head2往下移动
 *      如果head1的值与head2的值相等，则打印这个值，然后head1和head2同时往下移动
 *      其中，head1或head2有任何一个移动到null，整个过程停止
 */
public class PrintCommonPart {

    public static void printCommonPart(SingleNode head1, SingleNode head2) {
        System.out.println("Common part: ");
        while (head1!=null && head2!=null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
