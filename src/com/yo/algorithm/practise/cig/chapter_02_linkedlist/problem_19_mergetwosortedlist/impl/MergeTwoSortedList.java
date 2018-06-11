package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_19_mergetwosortedlist.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 合并两个有序链表
 */
public class MergeTwoSortedList {

    /**
     * 复制节点值合并，简单易懂
     * @param head1
     * @param head2
     * @return
     */
    public static SingleNode copy_merge(SingleNode head1, SingleNode head2) {
        SingleNode newHead = null;//合并之后链表的头部
        SingleNode newTail = null;//合并之后链表尾部
        SingleNode curr1 = head1;
        SingleNode curr2 = head2;
        while (curr1!=null || curr2!=null) {
            if (curr1!=null && curr2!=null) {
                //curr1和curr2均不为空
                if (curr1.value <= curr2.value) {
                    if (newTail == null) {
                        newHead = new SingleNode(curr1.value);
                        newHead.next = new SingleNode(curr2.value);
                        newTail = newHead.next;
                    } else {
                        newTail.next = new SingleNode(curr1.value);
                        newTail.next.next = new SingleNode(curr2.value);
                        newTail = newTail.next.next;
                    }
                } else {
                    if (newTail == null) {
                        newHead = new SingleNode(curr2.value);
                        newHead.next = new SingleNode(curr1.value);
                        newTail = newHead.next;
                    } else {
                        newTail.next = new SingleNode(curr2.value);
                        newTail.next.next = new SingleNode(curr1.value);
                        newTail = newTail.next.next;
                    }
                }
            } else if (curr1 != null) {
                //curr1不为空
                if (newTail == null) {
                    newHead = new SingleNode(curr1.value);
                    newTail = newHead;
                } else {
                    newTail.next = new SingleNode(curr1.value);
                    newTail = newTail.next;
                }
            } else {
                //curr2不为空
                if (newTail == null) {
                    newHead = new SingleNode(curr2.value);
                    newTail = newHead;
                } else {
                    newTail.next = new SingleNode(curr2.value);
                    newTail = newTail.next;
                }
            }
            curr1 = curr1!=null ? curr1.next : null;
            curr2 = curr2!=null ? curr2.next : null;
        }

        return newHead;
    }

    /**
     * 复用原节点，直接合并，代码简洁
     * @param head1
     * @param head2
     * @return
     */
    public static SingleNode merge(SingleNode head1, SingleNode head2) {
        if (head1==null || head2==null) {
            return head1==null ? head2 : head1;
        }
        //找出链表1和链表2中头节点值较小的节点
        SingleNode head = head1.value < head2.value ? head1 : head2;
        //如果头节点值较小的是链表1，则curr1为head1，否则head2
        SingleNode curr1 = head==head1 ? head1 : head2;
        //如果头节点值较小的是链表1，则curr2为head2，否则head1
        SingleNode curr2 = head==head1 ? head2 : head1;
        SingleNode pre = null;
        SingleNode next = null;
        while (curr1!=null && curr2!=null) {
            //如果链表1当前遍历到的节点的值比链表2当前遍历的节点的值小
            if (curr1.value <= curr2.value) {
                //设置pre为curr1
                pre = curr1;
                //将链表1当前遍历的节点往下移动
                curr1 = curr1.next;
            } else {//否则
                //保证链表2当前遍历到的节点的下一个节点
                next = curr2.next;
                //将pre的与当前值较小的节点（即链表2当前遍历到的节点）相连
                pre.next = curr2;
                //将链表2当前遍历到的节点的与链表1当前遍历到的节点相连，因为curr2.value<=curr1.value
                curr2.next = curr1;
                //更新pre为下一节点，即curr2
                pre  = curr2;
                //将链表2当前遍历的节点往下移动
                curr2 = next;
            }
        }
        //由于curr1和curr2并非同时移动，而是按值的顺序进行连接，所以链表中最大值比较小的链表会先遍历完
        //所以，当循环结束时，直接连接未遍历链表的剩下部分即可
        pre.next = curr1==null ? curr2 : curr1;
        return head;
    }

}
