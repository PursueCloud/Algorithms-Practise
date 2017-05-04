package com.yo.linkedlist.part1;

import com.yo.linkedlist.datastructure.ListNode;

/**环形链表插值练习题：
   有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
   给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
   测试样例：
       [1,3,4,5,7],[1,2,3,4,0],2
   返回：{1,2,3,4,5,7}
 * Created by Yo on 2017/3/4.
 */
public class InsertValue {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7};
        int[] nxt = {1, 2, 3, 4, 0};
        ListNode.traverseLinkedList(insert2
                (arr, nxt, 2));
    }

    public static ListNode insert(int[] A, int[] nxt, int val) {
        if(A.length == 0 || A == null){
            ListNode head = new ListNode(val);
            head.next = head;
            return head;
        }
        //根据数组构造链表
        ListNode head = new ListNode(A[0]);//头节点
        ListNode r = head;
        ListNode current;
        for(int i=0; i<nxt.length-1; i++){
            current = new ListNode(A[nxt[i]]);
            r.next = current;
            r = current;
        }
        //找到待插入的位置（前一个节点和后一个节点
        ListNode p = head;
        ListNode c = head.next;
        while( c != null ){
            if( p.val<=val && c.val>=val) {
                break;
            } else {
                p = c;
                c = c.next;
            }
        }
        //生成并插入节点
        ListNode node = new ListNode(val);
        p.next = node;
        node.next = c;
        if( val < head.val ) {
            return node;
        } else {
            return head;
        }
    }

    public static ListNode insert2(int[] A, int[] nxt, int val) {
        if( A==null || A.length<1 ) {
            ListNode head = new ListNode(val);
            return head;
        }
        //根据数组构造链表
        ListNode head = new ListNode(A[0]);
        ListNode r = head;
        ListNode current;
        for(int i=0; i<A.length-1; i++) {
            current = new ListNode(A[i]);
            r.next = current;
            r = current;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while( next != null ) {
            if( pre.val<=val && next.val>=val ) {
                break;
            } else {
                pre = next;
                next = next.next;
            }
        }
        ListNode node = new ListNode(val);
        pre.next = node;
        node.next = next;
        if( head.val > val ) {
            return node;
        } else {
            return head;
        }
    }
}
