package com.yo.algorithm.learning.string.part1;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;
import com.yo.algorithm.learning.binarytree.part1.Traverse;

import java.util.*;

/**
 * 拓扑结构相同子树练习题:
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
   给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
   解题思路：
      将两棵树序列化，然后判断A树序列化的字符串中是否含有B树序列化后的字符串，如果是，返回TRUE，否则返回FALSE
 * Created by Yo on 2017/3/4.
 */
public class IdenticalTree {
    public static void main(String[] args) {
         /*
                     1
                 2       3
              4     5  6    7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Traverse.preOrderTraverse_print_recursive(root);
        System.out.println();
        Traverse.preOrderTraverse_print_recursive(deSerializeTest(preSerializeTest(root)));
    }
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        if( A==null || B==null ) {
            return false;
        }
        String strA = preSerialize(A);
        String strB = preSerialize(B);
        if( strA.indexOf(strB) != -1 ) {
            return true;
        } else {
            return false;
        }
    }

    //先序遍历序列化
    public static String preSerialize(TreeNode root) {
        if( root == null ) {
            return "#!";
        }
        StringBuilder builder = new StringBuilder(root.value).append("!");
        builder.append(preSerialize(root.left));
        builder.append(preSerialize(root.right));

        return builder.toString();
    }
    //先序遍历反序列化
    public static TreeNode deSerialize(String treeStr) {
        if( treeStr==null || "".equals(treeStr) ) {
            return null;
        }
        String[] valArr = treeStr.split("!");
        LinkedList<String> queue = new LinkedList<String>();
        for(String val : valArr) {
            queue.add(val);
        }
        return preOrderGenerateTree(queue);
    }
    public static TreeNode preOrderGenerateTree(LinkedList<String> queue) {
        String val = queue.poll();
        if( "#".equals(val) ) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = preOrderGenerateTree(queue);
        root.right = preOrderGenerateTree(queue);

        return root;
    }
    public static String preSerializeTest(TreeNode root) {
        if( root == null ) {
            return "#!";
        }
        StringBuilder builder = new StringBuilder().append(root.value).append("!");
        builder.append(preSerializeTest(root.left));
        builder.append(preSerializeTest(root.right));
        return builder.toString();
    }
    public static TreeNode deSerializeTest(String treeStr) {
        if( treeStr==null || "".equals(treeStr) ) {
            return null;
        }
        String[] nodeValArr = treeStr.split("!");
        Queue<String> valQueue = new LinkedList<String>();
        for(String s : nodeValArr) {
            valQueue.add(s);
        }
        return preSerializeGenerateTest(valQueue);
    }
    private static TreeNode preSerializeGenerateTest(Queue<String> valQueue) {
        if( !valQueue.isEmpty() ) {
            String val = valQueue.poll();
            if( "#".equals(val) ) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = preSerializeGenerateTest(valQueue);
            root.right = preSerializeGenerateTest(valQueue);
            return root;
        }
        return null;
    }
}
