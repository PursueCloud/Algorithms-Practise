package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_03_printtreevisually.impl;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

/**
 * 直观地打印二叉树
 */
public class PrintTreeVisually {

    public static void printTreeIntuitive(TreeNode root) {
        System.out.println("Binary Tree:");
        printInOrder(root, 0, "H", 17);
        System.out.println();
    }
    private static void printInOrder(TreeNode root, int height, String to, int len) {
        if (root == null) {
            return;
        }
        printInOrder(root.right, height+1, "v", len);
        String val = to + root.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(root.left, height+1, "^", len);
    }
    private static String getSpace(int num) {
        String space = " ";
        StringBuilder buf = new StringBuilder("");
        for (int i=0; i<num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

}
