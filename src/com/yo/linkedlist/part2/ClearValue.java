package com.yo.linkedlist.part2;

import com.yo.linkedlist.datastructure.ListNode;

/**链表指定值清除练习题：
   现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
   给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
   测试样例：
       {1,2,3,4,3,2,1},2
   {1,3,4,3,1}
 * Created by Yo on 2017/3/5.
 */
public class ClearValue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4, 3, 5, 2, 1};
        ListNode.traverseLinkedList(clear(ListNode.generateListByArr(arr), 5));
    }
    public static ListNode clear(ListNode head, int val) {
        if( head == null ) {
            return null;
        }
        while( head != null) {//移除从头节点开始，所有值与指定值相当的连续的节点
            if( head.val != val ) {
                break;
            }
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while( cur != null ) {
            if( cur.val == val ) {
                pre.next = cur.next;//移除值与指定值相等的节点
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
