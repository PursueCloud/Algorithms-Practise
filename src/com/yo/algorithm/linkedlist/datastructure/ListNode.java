package com.yo.algorithm.linkedlist.datastructure;

/**
 * Created by Yo on 2017/3/4.
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 根据数组生成链表，返回链表的头结点
     * @param A
     * @return
     */
    public static ListNode generateListByArr(int[] A) {
        if( A==null || A.length<1 ) {
            return null;
        }
        //根据数组构造链表
        ListNode head = new ListNode(A[0]);//头节点
        ListNode r = head;
        ListNode current;
        for(int i=1; i<A.length; i++){
            current = new ListNode(A[i]);
            r.next = current;
            r = current;
        }
        return head;
    }

    /**
     * 遍历链表
     * @param head
     */
    public static void traverseLinkedList(ListNode head) {
        if( head == null ) {
            return;
        }
        System.out.print(head.val + " ");
        ListNode temp = head.next;
        while( temp != null ) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
