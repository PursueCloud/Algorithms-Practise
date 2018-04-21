package com.yo.algorithm.learning.binarytree.part2;

/**
 * 二叉树遍历
 * Created by Yo on 2017/2/26.
 */

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树打印和序列化
 */
public class Serialize {
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
        testSerializeAndDeSerialize(root);
    }

    /**
     * 测试序列化和反序列化方法
     * @param root
     */
    public static void testSerializeAndDeSerialize(TreeNode root) {
        //先序：1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!
        System.out.print("序列化-先序：");
        String treeString = toStringPre(root);
        System.out.println();
//        System.out.print("序列化-中序：");
//        //中序：#!4!#!2!#!5!#!1!#!6!#!3!#!7!#!
//        String treeString = toStringMid(root);
//        System.out.println();
//        System.out.print("序列化-后序：");
//        //后序：#!#!4!#!#!5!2!#!#!6!#!#!7!3!1!
//        String treeString = toStringLast(root);

        System.out.println(treeString);
        System.out.println("反序列化：");
        for(int[] res : TraverseByHierarchy.printByHierarchy(deSerialize(treeString))) {//遍历方法只会执行一次，这是由foreach的机制决定
            for(int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
//---递归序列化和反序列化(不传多余参数)
    public static String serialize(TreeNode root) {
        if( root == null ) {
            return "#!";
        }
        StringBuilder builder = new StringBuilder(root.value + "!");
        builder.append(serialize(root.left));
        builder.append(serialize(root.right));
        return builder.toString();
    }
    public static TreeNode deSerialize(String treeStr) {
        if( treeStr==null || "".equals(treeStr) ) {
            return null;
        }
        String[] treeStrArr = treeStr.split("!");
        LinkedList<String> queue = new LinkedList<String>();
        for(String ts : treeStrArr) {
            queue.add(ts);
        }
        return preOrder(queue);
    }
    public static TreeNode preOrder(LinkedList<String> queue) {
        String val = queue.poll();
        if( "#".equals(val) ) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = preOrder(queue);
        root.right = preOrder(queue);

        return root;
    }

    //---递归序列化和反序列化（传一个参数
    public static String toStringPre(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        return toStringPre_recursive(root, builder);
    }
    public static String toStringMid(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        return toStringMid_recursive(root, builder);
    }
    public static String toStringLast(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        return toStringLast_recursive(root, builder);
    }

    /**
     * 序列化（先序遍历-递归）
     * @param root
     * @return
     */
    public static String toStringPre_recursive(TreeNode root, StringBuilder builder) {
        if( root == null ) {
            builder.append("#!");
        } else {
            builder.append(root.value).append("!");
            toStringPre_recursive(root.left, builder);
            toStringPre_recursive(root.right, builder);
        }
        return builder.toString();
    }
    /**
     * 序列化（中序遍历-递归）
     * @param root
     * @return
     */
    public static String toStringMid_recursive(TreeNode root, StringBuilder builder) {
        if( root == null ) {
            builder.append("#!");
        } else {
            toStringMid_recursive(root.left, builder);
            builder.append(root.value).append("!");
            toStringMid_recursive(root.right, builder);
        }
        return builder.toString();
    }
    /**
     * 序列化(后序遍历-递归）
     * @param root
     * @return
     */
    public static String toStringLast_recursive(TreeNode root, StringBuilder builder) {
        if( root == null ) {
            builder.append("#!");
        } else {
            toStringLast_recursive(root.left, builder);
            toStringLast_recursive(root.right, builder);
            builder.append(root.value).append("!");
        }
        return builder.toString();
    }

}
