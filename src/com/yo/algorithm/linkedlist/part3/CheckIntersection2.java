package com.yo.algorithm.linkedlist.part3;

import com.yo.algorithm.linkedlist.datastructure.ListNode;

/**单链表相交判断练习题(未知是否有环)：
   给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
   给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 * Created by Yo on 2017/3/6.
 */
public class CheckIntersection2 {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if( chkLoop(head1) && chkLoop(head2) ) {//有环
            return chkIntersectWithLoop(head1, head2, adjust0, adjust1);
        } else {//无环
            return chkIntersectWithoutLoop(head1, head2, adjust0, adjust1);
        }
    }

    public static boolean chkLoop(ListNode head) {
        if( head==null && head.next==null ) {
            return false;
        }
        ListNode slow=head, quick=head;
        while( quick!=null && quick.next!=null ) {
            slow = slow.next;
            quick = quick.next.next;
            if( slow == quick ) {
                break;
            }
        }
        if( slow != quick ) {
            return false;
        }
        quick = head;
        while( quick != slow ) {
            slow = slow.next;
            quick = quick.next;
        }
        if( quick == slow ) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean chkIntersectWithoutLoop(ListNode headA, ListNode headB, int adjust0, int adjust1) {
        if( headA==null && headB==null ) {
            return false;
        }
        int lenA=0, lenB=0, diff=0;
        ListNode cur = headA;
        while( cur != null ) {
            lenA++;
            cur = cur.next;
        }
        cur = headB;
        while( cur != null ) {
            lenB++;
            cur = cur.next;
        }
        diff = Math.abs(lenA-lenB);
        while( diff-- > 0 ) {
            if( lenA > lenB ) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        while( headA!=null && headB!=null ) {
            if( headA == headB ) {
                return true;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return false;

    }

    public static ListNode getLoop(ListNode head) {
        if( head==null && head.next==null ) {
            return null;
        }
        ListNode slow=head, quick=head;
        while( quick!=null && quick.next!=null ) {
            slow = slow.next;
            quick = quick.next.next;
            if( slow == quick ) {
                break;
            }
        }
        if( slow != quick ) {
            return null;
        }
        quick = head;
        while( quick != slow ) {
            slow = slow.next;
            quick = quick.next;
        }
        return quick;
    }

    public static boolean  chkIntersectWithLoop(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode enter1 = getLoop(head1);
        ListNode enter2 = getLoop(head2);

        if( enter1 == enter2 ) {
            return true;
        } else {
            ListNode cur = enter1.next;
            while( cur != enter1 ) {
                if( cur == enter2 ) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }
    }
}
