package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_06_josephusproblem.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 环形单链表的约瑟夫问题
 */
public class JosephusProblem {

    public static SingleNode josephusKill(SingleNode head, int m) {
        if (head==null || head.next==head || m<1) {
            return head;
        }
        SingleNode curr = head.next;
        int tmp = 1;// tmp is list size
        while (curr != head) {
            tmp++;
            curr = curr.next;
        }
        tmp = getLive(tmp, m);// tmp is service njode position
        while (--tmp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    /**
     *
     * @param i 链表长度
     * @param m 被杀死的节点要累加到的序号（比如3）
     * @return
     */
    private static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i-1, m) + m - 1) % i + 1;
    }
}
