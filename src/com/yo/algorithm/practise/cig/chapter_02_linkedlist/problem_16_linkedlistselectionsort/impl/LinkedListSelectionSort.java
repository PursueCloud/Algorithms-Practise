package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_16_linkedlistselectionsort.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 单链表的选择排序
 */
public class LinkedListSelectionSort {

    /**
     * 时间复杂度：O(N^2)，额外空间复杂度：O(1)
     **/
    public static SingleNode selectionSort(SingleNode head) {
        SingleNode tail = null;//已排序部分尾部
        SingleNode curr = head;//未排序部分头部
        SingleNode small = null;//值最小的节点的前一个节点
        SingleNode smallPre = null;//值最小的节点
        while (curr != null) {
            small = curr;
            //获取当前链表值最小的节点的前一个节点
            smallPre = getSmallestPreNode(curr);
            //如果smallPre存在，则将small节点从未排序的链表中删除
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            //如果当前节点就是最小节点，则将当前节点往下移动，否则保持当前节点位置不变
            curr = curr==small ? curr.next : curr;
            //如果已排序的链表尾部为空，则设置一排序链表头部为small
            if (tail == null) {
                head = small;
            } else {//否则，将small节点连接到已排序链表的尾部
                tail.next = small;
            }
            //然后将tail指向已排序的链表尾部，即small节点
            tail = small;
        }

        return head;
    }
    /**
     * 获取当前链表值最小的节点的前一个节点
     **/
    private static SingleNode getSmallestPreNode(SingleNode head) {
        SingleNode pre = head;//当前节点的前一个节点
        SingleNode curr = head.next;//当前节点
        SingleNode small = head;//值最小的节点
        SingleNode smallPre = null;//值最小的节点的前一个节点
        while (curr != null) {
            //如果当前节点比当前值最小的节点的值要小，则更新small以及smallPre
            if (curr.value < small.value) {
                smallPre = pre;
                small = curr;
            }
            //pre及curr各自移动到下一节点
            pre = curr;
            curr = curr.next;
        }

        return smallPre;
    }
}
