package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_09_copyrandomnodelist.impl;

import com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_09_copyrandomnodelist.impl.entity.RandomNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机指针节点的链表
 */
public class CopyRandomNodeList {

    /**
     * 时间复杂度：O(N)，额外空间复杂度：O(N)
     * @param head
     * @return
     */
    public static RandomNode copyListWithRand1(RandomNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode curr = head;
        //第一次遍历，构造“原节点-复制节点”Map
        while (curr != null) {
            map.put(curr, new RandomNode(curr.value));
            curr = curr.next;
        }
        curr = head;
        //第二次遍历，将复制节点连接起来，并设置每个节点指向的随机节点
        while (curr != null) {
            RandomNode newNode = map.get(curr);
            //复制节点指向下一个复制节点
            newNode.next = map.get(curr.next);
            //复制节点指向当前节点指向的随机节点对应的复制节点
            newNode.rand = map.get(curr.rand);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static RandomNode copyListWithRand2(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode curr = head;
        RandomNode next = null;
        //将每一个原节点的复制节点连接在其原节点与其原节点的下一节点之间
        while (curr != null) {
            //保存下一个原节点
            next = curr.next;
            //将原节点与复制节点连接起来
            curr.next = new RandomNode(curr.value);
            //将原节点的复制节点与该原节点的下一个节点连接起来
            curr.next.next = next;
            //从下一个原节点开始
            curr = next;
        }
        //设置每一个复制节点的rand指针指向
        curr = head;
        while (curr != null) {
            //保存下一个原节点
            next = curr.next.next;
            //设置原节点的复制节点的rand指针指向，即指向原节点的rand指针指向的节点的复制节点（即rand指针指向节点的next指针指向的节点）
            curr.next.rand = curr.rand!=null ? curr.rand.next : null;
            //从下一个原节点开始
            curr = next;
        }
        //保存第一个复制节点，作为复制链表的头节点返回
        RandomNode copyHead = head.next;
        //连接各类复制节点与原节点并拆分
        curr = head;
        while (curr != null) {
            //保存下一个原节点
            next = curr.next.next;
            //连接复制节点与其下一个复制节点
            curr.next.next = next!=null ? next.next : null;
            //连接原节点与其下一个原节点
            curr.next = next;
            //从下一个原节点开始
            curr = next;
        }

        return copyHead;
    }
}
