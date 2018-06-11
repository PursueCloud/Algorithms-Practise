package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_20_recombinelinkedlist.impl;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

/**
 * 按照左右半区的方式重新组合单链表
 */
public class RecombineLinkedList {

    /**
     * 测试结果：
             before recombining :

             after recombining :

             before recombining :
             1
             after recombining :
             1
             before recombining :
             1 2
             after recombining :
             1 2
             before recombining :
             1 2 3
             after recombining :
             1 3 2
             before recombining :
             1 2 3 4
             after recombining :
             1 3 2 4
             before recombining :
             1 2 3 4 5
             after recombining :
             1 4 2 5 3
             before recombining :
             1 2 3 4 5 6
             after recombining :
             1 4 2 5 3 6
             before recombining :
             1 2 3 4 5 6 7
             after recombining :
             1 5 2 6 3 7 4
     * @param head
     * @return
     */
    public static SingleNode recombine(SingleNode head) {
        if (head == null) {
            return null;
        }
        SingleNode left = head;
        SingleNode right = head;
        //找到中间节点
        while (right.next!=null && right.next.next!=null) {
            left = left.next;
            right = right.next.next;
        }
        //右半区
        right = left.next;
        //断开左半区与右半区的连接
        left.next = null;
        //left指向左半区
        left = head;
        SingleNode next = null;
        //重新组合左半区与右半区每一个节点
        while (left !=null && right !=null) {
            //保存右半区当前遍历节点的下一个节点
            next = right.next;
            //将右半区当前遍历的节点与左半区当前遍历节点的下一个节点连接起来
            // (即用right.next保存右半区的下一个节点，留作移动左半区用，同时省了一个变量空间)
            right.next = left.next;
            //将左半区和右半区当前遍历的节点连接起来
            left.next = right;

            //将左半区和右半区当前遍历的节点同步往下移动
            left = right.next;
            right = next;
        }

        return head;
    }

}
