package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_02_printedge.impl;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

/**
 * 打印树的边界节点
 */
public class PrintEdge {

    /**
     * 打印树的边界1，标准如下：
     *
     * @param root
     */
    public static void printEdge1(TreeNode root) {
        if (root == null) {
            return;
        }
        int height = getHeight(root, 0);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        setEdgeMap(root, 0, edgeMap);
        //打印左边界
        for (int i=0; i!=edgeMap.length; i++) {
            System.out.print(edgeMap[i][0].value + " ");
        }
        //打印既不是左边界，也不是右边界的叶子节点
        printLeafNotInMap(root, 0, edgeMap);
        //打印右边界，但不是左边界的节点
        for (int i=edgeMap.length; i!=-1; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.print(edgeMap[i][1].value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 获取树的高度
     * @param node
     * @param level
     * @return
     */
    private static int getHeight(TreeNode node, int level) {
        if (node == null) {
            return 1;
        }
        //左子树的高度与右子树的高度中较大的那个
        return Math.max(getHeight(node.left, level+1), getHeight(node.right, level+1));
    }
    private static void setEdgeMap(TreeNode node, int level, TreeNode[][] edgeMap) {
        if (node == null) {
            return;
        }
        edgeMap[level][0] = edgeMap[level][0]==null ? node : edgeMap[level][0];
        edgeMap[level][1] = node;
        setEdgeMap(node.left, level+1, edgeMap);
        setEdgeMap(node.right, level+1, edgeMap);
    }
    private static void printLeafNotInMap(TreeNode node, int level, TreeNode[][] m) {
        if (node == null) {
            return;
        }
        if (node.left==null && node.right==null && node!=m[level][0] && node!=m[level][1]) {
            System.out.print(node.value + " ");
        }
        printLeafNotInMap(node.left, level+1, m);
        printLeafNotInMap(node.right, level+1, m);
    }

    /**
     * 打印树的边界2，标准如下：
     */
    public static void printEdge2(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        if (root.left!=null && root.right!=null) {
            printLeftEdge(root.left, true);
            printRightEdge(root.right, true);
        } else {
            printEdge2(root.left!=null ? root.left : root.right);
        }
        System.out.println();
    }
    private static void printLeftEdge(TreeNode node, boolean print) {
        if (node == null) {
            return;
        }
        if (print || (node.left==null && node.right==null)) {
            System.out.print(node.value + " ");
        }
        printLeftEdge(node.left, print);
        printLeftEdge(node.right, print && node.left==null ? true : false);
    }
    private static void printRightEdge(TreeNode node, boolean print) {
        if (node == null) {
            return;
        }
        printRightEdge(node.left, print && node.right==null ? true : false);
        printRightEdge(node.right, print);
        if (print || (node.left==null && node.right==null)) {
            System.out.print(node.value + " ");
        }
    }
}
