package com.yo.algorithm.learning.linkedlist.part1;

import com.yo.algorithm.learning.linkedlist.datastructure.ListNode;

/**访问单个节点的删除练习题：
   实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
   给定带删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 * Created by Yo on 2017/3/5.
 */
public class Remove {
    public boolean removeNode(ListNode pNode) {
        if( pNode.next == null ) {
            return false;
        }
        ListNode next = pNode.next;
        pNode.val = next.val;
        pNode.next = next.next;
        next = null;
        return true;
    }
}
