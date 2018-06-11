package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_13_removeduplicatevalnode.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除无序单链表中值重复出现的节点
 */
public class RemoveDuplicateValNode {

    /**
     * 时间复杂度：O(N)，额外空间复杂度：O(N)，因为用到了哈希表
     * @param head
     * @return
     */
    public static void removeDuplicateValNode1(SingleNode head) {
        if (head == null) {
            return;
        }
        Map<String, Boolean> duplicateValMap = new HashMap<>();//可使用HashSet替代
        SingleNode curr = head;
        SingleNode pre = null;
        while (curr != null) {
            Boolean exists = duplicateValMap.get(curr.value + "");
            //如果当前节点的值已经出现过，则删除当前节点
            if (exists!=null && exists) {//当使用HashSet时，此时替换成Set的contains方法即可
                pre.next = curr.next;
            } else {
                duplicateValMap.put(curr.value + "", true);//当使用HashSet时，此时替换成Set的add方法即可
                pre = curr;
            }
            curr = curr.next;
        }
    }

    /**
     * 时间复杂度：O(N^2)，额外空间复杂度：O(1)
     * @param head
     */
    public static void removeDuplicateValNode2(SingleNode head) {
        if (head == null) {
            return;
        }
        SingleNode curr = head;
        SingleNode next = null;
        SingleNode preNext = null;
        while (curr != null) {
            next = curr.next;
            preNext = curr;
            //从当前节点开始，往下遍历，如果发现有跟当前节点相同的值，则将其删除
            while (next != null) {
                if (next.value == curr.value) {
                    preNext.next = next.next;
                } else {
                    preNext = next;
                }
                next = next.next;
            }
            curr = curr.next;
        }
    }
}
