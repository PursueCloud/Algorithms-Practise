package com.yo.algorithm.linkedlist.part3;

import com.yo.algorithm.linkedlist.datastructure.ListNode;

/**无环单链表判相交练习题:
   现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
   给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。
 * Created by Yo on 2017/3/6.
 */
public class CheckIntersection2WithoutLoop {
    public static void main(String[] args) {

    }

    /**
     * 正解
       判断两个无环单链表是否相交
       先各自遍历一次，分别得到两个链表的长度差值diff，然后让长的链表先走diff步，之后再通过比较判断二者是否相交
     * @param headA
     * @param headB
     * @return
     */
    public static boolean chkIntersect(ListNode headA, ListNode headB) {
        if( headA==null || headB==null ) {
            return false;
        }
        //得到两个链表的长度，并求得差值
        int lenA=0, lenB=0, diff=0;
        ListNode cur = headA;
        while( cur != null ) {
            lenA++;
            cur = cur.next;
        }
        cur = headB;
        while( cur != null ){
            lenB++;
            cur = cur.next;
        }
        diff = Math.abs(lenA-lenB);

        //长的链表先走
        while( diff-- > 0 ) {
            if( lenA > lenB ) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        //同时走
        while( headA!=null && headB!=null ) {
            if( headA == headB ) {
                return true;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return false;
    }

    /**
     * 错误
     * @param headA
     * @param headB
     * @return
     */
    public static boolean chkIntersect2(ListNode headA, ListNode headB) {
        if ( headA==null || headB==null ) {
            return false;
        }
        ListNode curA = headA;
        while( curA.next != null ) {
            curA = curA.next;
        }
        ListNode curB = headB;
        while( curB.next != null ) {
            curB = curB.next;
        }
        return curA == curB;
    }

}
