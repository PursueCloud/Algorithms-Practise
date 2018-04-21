package com.yo.algorithm.learning.linkedlist.part3;

import com.yo.algorithm.learning.linkedlist.datastructure.ListNode;

/**链表判环练习题：
   如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
   给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
   解题思路：
       设置两个指针，一个快指针quick，每次走2不，一个慢指针slow，每次走一步。当快指针与慢指针相等时（表示链表有环，
   否则，返回无环），当quick走到尾节点时将quick重新设置为head节点，并重新开始遍历.当遍历过程中quick指针再次追上（等于）slow指针，
   当前节点即为链表进入环的第一个节点
    - - - - quick-| ---- |
                 |slow__|
 * Created by Yo on 2017/3/6.
 */
public class ChectLoop {
    public static void main(String[] args) {

    }

    public int chkLoop(ListNode head, int adjust) {
        if( head==null || head.next==null ) {
            return -1;
        }
        ListNode slow=head, quick=head;
        boolean circle = false;
        while( quick.next!=null && quick.next.next!=null ) {
            slow = slow.next;
            quick = quick.next.next;
            if( slow == quick ) {//当慢指针slow与快指针quick相遇时，表示链表有环
                circle = true;
                break;
            }
        }
        if( !circle ) {//无环
            return -1;
        }
        quick = head;//将快指针设置为head，当慢指针slow再次与快指针相遇时，表示当前节点为进入环的第一个节点
        while( quick != slow ) {
            slow = slow.next;
            quick = quick.next;
        }
        return quick.val;
    }
}
