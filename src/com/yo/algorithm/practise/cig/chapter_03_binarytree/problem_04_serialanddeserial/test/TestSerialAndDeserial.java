package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_04_serialanddeserial.test;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_03_printtreeintuitively.impl.PrintTreeIntuitively.printTreeIntuitive;
import static com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_04_serialanddeserial.impl.SerializeAndDeserialize.*;

/**
 * 测试 - 二叉树的序列化和反序列化
 */
public class TestSerialAndDeserial {

    public static void main(String[] args) {
        TreeNode head = null;
        printTreeIntuitive(head);

        String pre = serialInPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = deserialByPreStr(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTreeIntuitive(head);

        String level = serialInLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = deserialByLevelStr(level);
        System.out.print("reconstruct tree by level, ");
        printTreeIntuitive(head);

        System.out.println("====================================");

        head = new TreeNode(1);
        printTreeIntuitive(head);

        pre = serialInPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = deserialByPreStr(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTreeIntuitive(head);

        level = serialInLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = deserialByLevelStr(level);
        System.out.print("reconstruct tree by level, ");
        printTreeIntuitive(head);

        System.out.println("====================================");

        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        printTreeIntuitive(head);

        pre = serialInPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = deserialByPreStr(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTreeIntuitive(head);

        level = serialInLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = deserialByLevelStr(level);
        System.out.print("reconstruct tree by level, ");
        printTreeIntuitive(head);

        System.out.println("====================================");

        head = new TreeNode(100);
        head.left = new TreeNode(21);
        head.left.left = new TreeNode(37);
        head.right = new TreeNode(-42);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(666);
        printTreeIntuitive(head);

        pre = serialInPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = deserialByPreStr(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTreeIntuitive(head);

        level = serialInLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = deserialByLevelStr(level);
        System.out.print("reconstruct tree by level, ");
        printTreeIntuitive(head);

        System.out.println("====================================");
    }
}
