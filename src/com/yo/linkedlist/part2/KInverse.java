package com.yo.linkedlist.part2;

import com.yo.linkedlist.datastructure.ListNode;

import java.util.Stack;

/**链表的k逆序练习题
   有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
   给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
   解题思路：
       ①：循环遍历链表，每次判断是否存在k个节点，如果是，则一次将节点压入栈中，然后取出；否则退出循环
       ②：（最优解）循环遍历链表，找到需要逆序的k个节点中的开始节点start和结束节点end，然后对start
       和end之间的简单做逆序调整
 * Created by Yo on 2017/3/5.
 */
public class KInverse {
    public static void main(String[] args) {
        int[] a = {0,4,9,11,12,14,20,24};
        ListNode headA = ListNode.generateListByArr(a);
        ListNode.traverseLinkedList(inverse(headA, 2));
    }

    /**最优解
     * 使用栈：O（n），O（1）
     * @param head
     * @param k
     * @return
     */
    public static ListNode inverse(ListNode head, int k) {
        if( head==null || head.next==null || k < 2 ) {
            return head;
        }
        ListNode cur=head, pre=null, start=null, next=null;
        int count = 1;
        while( cur != null ){
            next = cur.next;
            if( count == k ){
                start = pre==null ? head : pre.next;
                head = pre==null ? cur : head;
                reverseList(pre,start,cur,next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }
    private static void reverseList(ListNode left,ListNode start,ListNode end,ListNode right){
        ListNode pre=start, cur=start.next, next=null;
        while( cur != right ){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if( left != null ){
            left.next = end;
        }
        start.next = right;
    }
    /**
     * 使用栈：O（n），O（k）
     * @param head
     * @param k
     * @return
     */
    public ListNode inverse2(ListNode head, int k) {
        if( head==null || head.next==null || k<2 ) {
            return head;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode temp=head, q=null;
        while( temp != null ) {
            boolean hasKHierarcy = true;
            q = temp;
            for(int i=1; i<k; i++) {//从1~k-1算起，因为q本身算一个非空节点
                if( q.next == null ) {
                    hasKHierarcy = false;
                    break;
                } else {
                    q = q.next;
                }
            }
            if( hasKHierarcy ) {
                q = temp;
                for(int i=0; i<k; i++) {
                    //将数据压入栈中
                    stack.push(q.val);
                    q = q.next;
                }
                //从栈中取出数据集
                for(int i=0; i<k; i++) {
                    temp.val = stack.pop();
                    temp = temp.next;
                }
            } else {
                break;
            }
        }
        return head;
    }

}
