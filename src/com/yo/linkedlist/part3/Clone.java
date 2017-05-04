package com.yo.linkedlist.part3;

import com.yo.linkedlist.datastructure.RandomListNode;

/**复杂链表的复制练习题：
   输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * Created by Yo on 2017/3/6.
 */
public class Clone {
    public static void main(String[] args) {

    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if( pHead == null ) {
            return null;
        }
        RandomListNode node=pHead, tmp=null;
        while( node != null ) { //拷贝
            tmp = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = tmp;
            node = tmp;
        }
        node = pHead;
        RandomListNode nodeCopy = null;
        while( node != null ) {//拷贝节点random指针
            tmp = node.next.next;
            nodeCopy = node.next;
            nodeCopy.random = node.random==null ? null : node.random.next;
            node = tmp;
        }
        node = pHead;
        RandomListNode resHead = pHead.next;
        while( node != null ) {//分离出两个链表
            tmp = node.next.next;
            nodeCopy = node.next;
            node.next = tmp;
            nodeCopy.next = tmp==null ? null : tmp.next;
            node = tmp;
        }
        return resHead;
    }

}
