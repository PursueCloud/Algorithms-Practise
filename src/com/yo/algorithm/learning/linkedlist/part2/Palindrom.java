package com.yo.algorithm.learning.linkedlist.part2;

import com.yo.algorithm.learning.linkedlist.datastructure.ListNode;

import java.util.Stack;

/**链表的回文结构练习题：
   请编写一个函数，检查链表是否为回文。
   给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
   测试样例：
       {1,2,3,2,1}
   返回：true
       {1,2,3,2,3}
   返回：false
 * Created by Yo on 2017/3/5.
 */
public class Palindrom {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        System.out.println(isPalindrome(ListNode.generateListByArr(arr)));
    }
    /**最优解
     * O(n), O(1)
     * @param pHead
     * @return
     */
    public static boolean isPalindrome(ListNode pHead) {
        if( pHead==null || pHead.next==null ) {
            return false;
        }
        ListNode slow=pHead, quick=pHead;
        while( quick.next!=null && quick.next.next!=null) {
            slow = slow.next;// slow -> mid
            quick = quick.next.next;// quick -> end
        }
        quick = slow.next;// quick -> right part first node
        slow.next = null;// mid.next -> null
        ListNode next = null;
        while( quick != null ) {// right part convert
            next = quick.next;// next -> save next node
            quick.next = slow;// next of right node convert
            slow = quick;// slow move
            quick = next;// quick move
        }
        ListNode pre = slow;// pre -> save last node
        quick = pHead;// quick -> left first node
        boolean res = true;
        while( slow!=null && quick!=null ) {// check palindrome
            if( slow.val != quick.val ) {
                res = false;
                break;
            }
            slow = slow.next;// left to mid
            quick = quick.next;// right to mid
        }
        slow = pre.next;
        pre.next = null;
        while( slow != null ) {// recover list
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        return res;
    }
    /**
     * O(n), O(n/2)
     * @param pHead
     * @return
     */
    public static boolean isPalindrome2(ListNode pHead) {
        if( pHead==null || pHead.next==null ) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode slow=pHead, quick=pHead;
        while( quick!=null && quick.next!=null ) {
            stack.push(slow.val);
            slow = slow.next;
            quick = quick.next.next;
        }
        if( quick!=null && quick.next==null ) {
            slow = slow.next;
        }
        while( !stack.isEmpty() && slow!=null ) {
            int val = stack.pop();
            if( val != slow.val ) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    /**
     * O(n), O(n)
     * @param pHead
     * @return
     */
    public static boolean isPalindrome3(ListNode pHead) {
        if( pHead == null ) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode cur = pHead;
        while( cur != null ) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = pHead;
        while( cur != null ) {
            if( !stack.isEmpty() ) {
                if( cur.val != stack.pop() ) {
                    return false;
                }
            }
            cur = cur.next;
        }
        return true;
    }
}
