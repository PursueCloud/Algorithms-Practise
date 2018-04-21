package com.yo.algorithm.learning.linkedlist.part3;

import com.yo.algorithm.learning.linkedlist.datastructure.ListNode;

/**有环单链表相交判断练习题 :
   如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
   给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 * Created by Yo on 2017/3/6.
 */
public class CheckIntersection2WithLoop {
    public static void main(String[] args) {

    }

    //判断两个有环单链表是否相交
    //通过比较两个链表的入环节点node1, node2, 考虑以下三种情况：
    //(1)node1==node2,入环前就已经相交
    //(2)node1!=node2 && node1在环内遇不到node2, 两者不相交
    //(3)node1!=node2 && node1在环内可以遇到node2，两者相交
    public static boolean chkIntersectLoop(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if( head1==null || head2==null ) {
            return false;
        }
        ListNode enter1 = chkLoop(head1);
        ListNode enter2 = chkLoop(head2);

        if( enter1 == enter2 ) {
            return true;
        } else {
            ListNode cur = enter1.next;
            while( cur != enter1 ){
                if( cur == enter2 ) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }
    }

    //环的入口节点，无环则返回null
    public  static ListNode chkLoop(ListNode head) {
        if( head==null || head.next==null ) {
            return null;
        }
        ListNode slow=head, quick=head;
        while( quick!=null && quick.next!=null ){
            slow = slow.next;
            quick = quick.next.next;
            if( slow == quick ) {
                break;
            }
        }
        if( slow != quick ) {
            return null;//无环
        }
        quick = head;
        while( quick != slow ){
            quick = quick.next;
            slow = slow.next;
        }

        return quick;//返回环的入口
    }
}
