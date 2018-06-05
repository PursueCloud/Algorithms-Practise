package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_03_removenodebyratio.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 删除单链表中间节点、根据比率删除节点（有规律可循）
 */
public class RemoveNode {

    public static SingleNode removeMidNode(SingleNode head) {
        if (head==null || head.next==null || head.next.next == null) {
            //如果链表为空或仅有一个节点，则不需要删除节点，即返回的被删除节点为空
            return null;
        }
        //pre表示待删除节点的前一个节点
        SingleNode pre = head;
        SingleNode curr = head.next.next;
        //每多2个节点，pre就往后移动一个
        while (curr.next!=null && curr.next.next!=null) {
            pre = pre.next;
            curr = curr.next.next;
        }
        //保存被删除的节点
        SingleNode deleted = pre.next;
        pre.next = pre.next.next;
        //返回被删除的节点
        return deleted;
    }

    public static SingleNode removeNodeByRatio(SingleNode head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        SingleNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        //求待删除节点位置
        n = (int) Math.ceil(1.0 * a * n / b);
        SingleNode deleted = null;
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            //找到待删除节点的前置节点(如待删除为第n个，则其前置节点及为第n-1个，故将n--直至其等于1即可)
            curr = head;
            while (--n != 1) {
                curr = curr.next;
            }
            //保存被删除的节点
            deleted = curr.next;
            curr.next = curr.next.next;
        }
        //返回被删除的节点
        return deleted;
    }
}
