package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_17_strangedeletenode.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 一种怪异的节点删除方式
 * 题目描述：
 *         链表节点值类型为int型，给定一个链表中的节点node，但不给定整个链表的头节点。如果在链表中删除node？
 *         请实现这个函数，并分析这样会出现哪些问题。
 * 要求：
 *      时间复杂度为O(1)
 */
public class StrangeDeleteNode {

    /**
     * 思路：
     *      将该节点的下一个节点的值复制到该节点，然后删除下一个节点
     * 问题：
     *      1、无法删除最后一个节点
     *      2、节点值复制可能很复杂，或者可能改变节点值的操作都是被禁止的，而导致该方式无法实现
     *      3、外界对每个节点都有很多依赖，复制节点然后删除该节点后，会影响到该节点对外提供的服务
     *
     * @param node
     */
    public static void deleteNodeWired(SingleNode node) {
        if (node == null) {
            return;
        }
        SingleNode next = node.next;
        if (next == null) {
            throw new IllegalStateException("cat not delete the last node!");
        }
        node.value = next.value;
        node.next = next.next;
    }
}
