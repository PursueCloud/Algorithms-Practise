package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_02_removelastkthnode.impl;

import com.yo.algorithm.practise.cig.common.entity.DoubleNode;
import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 在单链表和双链表中删除倒数第k个节点
 * 思路：
 *      从头节点开始遍历，每遍历一次，k-1.当遍历到尾节点的时候，k的值有3中情况，根据这3中情况，删除倒数第k个节点有以下处理方法：
 *          1、当k等于0时，表示头节点的下一个节点就是待删除节点。这时由于头节点已知，故直接将头节点的next指针指向往下移（双链表要同时将待删除节点的下一节点的last指针指向head）即可
 *          2、当k大于0是，表示待删除节点不存在，直接返回头节点即可
 *          3、当k小于0时，表示待删除节点在第一个节点与最后一个节点之间，这时，只需重头开始遍历链表，遍历过程中，k+1，当k等于0时，退出遍历流程。
 *          这时遍历到的节点就是待删除节点的前一个节点（第N-k个节点），最后将该节点的next指针指向往下移（双链表要同时将待删除节点的下一节点的last指针指向当前遍历节点）即可。
 *          原理或公式如下所述：
 *              遍历到尾节点时，k的值变为k-N，而当重头遍历k且k+1时，当k的值变为0时，当前遍历到的节点正好是第N-k个，即待删除节点的前一个。
 *              由k - N + x = 0 得出，重头遍历所花步数（即x）为N-k个，而N-k即为待删除节点的前置节点
 */
public class RemoveLastKthNode {

    public static SingleNode removeLastKthNode(SingleNode head, int lastKth) {
        if (head == null || lastKth<1) {
            return head;
        }
        SingleNode curr = head;
        while (curr != null) {
            lastKth--;
            curr = curr.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            curr = head;
            while (++lastKth != 0) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        //lastKth > 0 的情况，表示倒数第k个节点不存在，直接返回即可
        return head;
    }


    public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth<1) {
            return head;
        }
        DoubleNode curr = head;
        while (curr != null) {
            lastKth--;
            curr = curr.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0) {
            curr = head;
            while (++lastKth != 0) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            if (curr.next != null) {
                curr.next.last = curr;
            }
        }
        //lastKth > 0 的情况，表示倒数第k个节点不存在，直接返回即可
        return head;
    }
}
