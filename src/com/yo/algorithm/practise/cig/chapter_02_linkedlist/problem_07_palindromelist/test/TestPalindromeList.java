package com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_07_palindromelist.test;

import com.yo.algorithm.practise.cig.common.entity.SingleNode;

import static com.yo.algorithm.practise.cig.chapter_02_linkedlist.problem_07_palindromelist.impl.PalindromeList.*;
import static com.yo.algorithm.practise.cig.common.util.LinkedListUtil.printLinkedList;

/**
 * 测试 - 判断单链表是否回文结构
 */
public class TestPalindromeList {

    public static void main(String[] args) {
        SingleNode head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome_best(head));
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome_best(head));
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome_best(head));
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.next = new SingleNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome_best(head));
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome_best(head));
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome_best(head));
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome_best(head));
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(2);
        head.next.next.next = new SingleNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome_best(head));
        printLinkedList(head);
        System.out.println("=========================");

        head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(2);
        head.next.next.next.next = new SingleNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome_best(head));
        printLinkedList(head);
        System.out.println("=========================");
    }
}
