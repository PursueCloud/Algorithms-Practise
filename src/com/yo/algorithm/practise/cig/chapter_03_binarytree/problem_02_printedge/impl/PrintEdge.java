package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_02_printedge.impl;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

/**
 * 打印树的边界节点
 */
public class PrintEdge {

    /**
     * 打印树的边界1，标准如下：
     * 1、头节点为边界节点
     * 2、叶子节点为边界节点
     * 3、如果节点在其所在的层中时最左或最右，那么也是边界节点
     * @param root
     */
    public static void printEdge1(TreeNode root) {
        if (root == null) {
            return;
        }
        //获取树的高度
        int height = getHeight(root, 0);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        setEdge(root, 0, edgeMap);
        //打印左边界
        for (int i=0; i<edgeMap.length; i++) {
            System.out.print(edgeMap[i][0].value + " ");
        }
        //打印既不是左边界也不是右边界的非叶子节点
        printNotLeafInMap(root, 0, edgeMap);
        //打印右边界
        for (int i=edgeMap.length-1; i>-1; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.print(edgeMap[i][1].value + " ");
            }
        }
        System.out.println();
    }
    /**
     * 获取二叉树的高度
     **/
    private static int getHeight(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        return Math.max(getHeight(root.left, level+1), getHeight(root.right, level+1));
    }
    /**
     * 设置二叉树每一层的左边界和右边界
     **/
    private static void setEdge(TreeNode node, int level, TreeNode[][] edgeMap) {
        if (node == null) {
            return;
        }
        //左边界
        edgeMap[level][0] = edgeMap[level][0]==null ? node : edgeMap[level][0];
        //右边界
        edgeMap[level][1] = node;
        //递归设置左子树每一层的左边界和右边界
        setEdge(node.left, level+1, edgeMap);
        //递归设置右子树每一层的左边界和右边界
        setEdge(node.right, level+1, edgeMap);
    }
    /**
     * 打印既不是左边界也不是右边界的非叶子节点
     **/
    private static void printNotLeafInMap(TreeNode node, int level, TreeNode[][] map) {
        if (node == null) {
            return;
        }
        if (node.left==null && node.right==null &&
                node!=map[level][0] && node!=map[level][1]) {
            System.out.print(node.value + " ");
        }
        printNotLeafInMap(node.left, level+1, map);
        printNotLeafInMap(node.right, level+1, map);
    }


    /**
     * 打印树的边界2，标准如下：
     * 1、头结点为边界节点
     * 2、叶子节点为边界节点
     * 3、树左边界延伸下去的路径为边界节点
     * 4、树右边界延伸下去的路径为边界节点
     */
    public static void printEdge2(TreeNode root) {
        if (root == null) {
            return;
        }
        //先打印头节点
        System.out.print(root.value + " ");
        //如果头节点左子树和右子树都不为空，则分别打印左子树和右子树的边界节点
        if (root.left!=null && root.right!=null) {
            printLeftEdge(root.left, true);
            printRightEdge(root.right, true);
        } else {
            //否则只打印其中一颗子树的边界节点
            printEdge2(root.left!=null ? root.left :
                    root.right);
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
        printLeftEdge(node.right, print && node.left==null);
    }
    private static void printRightEdge(TreeNode node, boolean print) {
        if (node == null) {
            return;
        }
        printRightEdge(node.left, print && node.right==null);
        printRightEdge(node.right, print);
        if (print || (node.left==null && node.right==null)) {
            System.out.print(node.value + " ");
        }
    }

}
