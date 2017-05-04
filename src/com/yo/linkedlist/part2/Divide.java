package com.yo.linkedlist.part2;

import com.yo.linkedlist.datastructure.ListNode;

/**链表的分化练习题：
   对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
   给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
   测试样例：
       {1,4,2,5},3
   返回{1,2,4,5}
 * Created by Yo on 2017/3/5.
 */
public class Divide {
    public static void main(String[] args) {
        int[] arr = {1134,861,563,1,1620};
        ListNode.traverseLinkedList(listDivide(ListNode.generateListByArr(arr), 1134));
    }

    /**最优解
     * O(n),O(1)
     * @param head
     * @param val
     * @return
     */
    public static ListNode listDivide(ListNode head, int val) {
        if( head==null || head.next== null) {
            return head;
        }
        //小于部分头尾节点
        ListNode sHead=null, sTail=null;
        //大于部分头尾节点
        ListNode bHead=null, bTail=null;
        ListNode p=head, next=null;
        while( p != null ) {
            next = p.next;
            p.next = null;
            if( p.val <= val ) {//小于等于部分放到小于部分链表中
                if( sHead == null ) {
                    sHead = p;
                    sTail = p;
                } else {
                    sTail.next = p;
                    sTail = p;
                }
            } else {//大于部分放到大于部分链表中
                if( bHead == null ) {
                    bHead = p;
                    bTail = p;
                } else {
                    bTail.next = p;
                    bTail = p;
                }
            }
            p = next;
        }
        if( sTail != null ) {//
            sTail.next = bHead;
        }

        return sHead!=null ? sHead : bHead;
    }

}
