package com.yo.algorithm.linkedlist.part2;

import com.yo.algorithm.linkedlist.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**打印两个链表的公共值练习题
   现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
   给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
   测试样例：
       {1,2,3,4,5,6,7},{2,4,6,8,10}
   返回：[2.4.6]
   解题思路：
       循环遍历两个链表，如果此时两个链表的值相同，则添加值，并同时后移两个链表的位置；如果第一个链表值较大，
   则后移第一个链表位置；否则，后移第二个链表位置。要注意，如果某一个链表已经遍历完了，则退出循环
 * Created by Yo on 2017/3/5.
 */
public class Common {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {2, 4, 6, 8, 10};
        ListNode headA = ListNode.generateListByArr(a);
        ListNode headB = ListNode.generateListByArr(b);
        System.out.println(Arrays.toString(findCommonParts(headA, headB)));
    }
    public static int[] findCommonParts(ListNode headA, ListNode headB) {
        if( headA==null || headB==null ) {
            return null;
        }
        List<Integer> resList = new ArrayList<Integer>();
        //找出公共的值
        ListNode tempA=headA, tempB=headB;
        while( tempA!=null && tempB!=null ) {
            if( tempA.val == tempB.val ) {
                resList.add(tempA.val);
                tempA = tempA.next;
                tempB = tempB.next;
            } else if( tempA.val > tempB.val ) {
                tempB = tempB.next;
            } else {
                tempA = tempA.next;
            }
        }

        int[] res = new int[resList.size()];
        int index = 0;
        for(int a : resList) {
            res[index++] = a;
        }
        return res;
    }
}
