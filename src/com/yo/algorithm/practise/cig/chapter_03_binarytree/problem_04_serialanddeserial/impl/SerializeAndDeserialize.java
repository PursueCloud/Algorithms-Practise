package com.yo.algorithm.practise.cig.chapter_03_binarytree.problem_04_serialanddeserial.impl;

import com.yo.algorithm.learning.binarytree.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 */
public class SerializeAndDeserialize {

    /**
     * 序列化-先序遍历
     * #号表示空，!号表示一个节点结束（防止出现歧义）
     * @param root
     * @return
     */
    public static String serialInPre(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String result = root.value + "!";
        result += serialInPre(root.left);
        result += serialInPre(root.right);

        return result;
    }

    /**
     * 反序列化 - 先序遍历
     * @param serialStr
     * @return
     */
    public static TreeNode deserialByPreStr(String serialStr) {
        String[] split = serialStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String val : split) {
            queue.offer(val);
        }
        return deserialPreOrder(queue);
    }
    private static TreeNode deserialPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserialPreOrder(queue);
        root.right = deserialPreOrder(queue);
        return root;
    }


    /**
     * 序列化 - 按层次遍历（广度优先遍历）
     * @param root
     * @return
     */
    public static String serialInLevel(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String result = root.value + "!";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.left != null) {
                result += curr.left.value + "!";
                queue.offer(curr.left);
            } else {
                result += "#!";
            }
            if (curr.right != null) {
                result += curr.right.value + "!";
                queue.offer(curr.right);
            } else {
                result += "#!";
            }
        }
        return result;
    }

    /**
     * 反序列化 - 按层次遍历（广度优先遍历）
     * @param levelStr
     * @return
     */
    public static TreeNode deserialByLevelStr(String levelStr) {
        if (levelStr == null || levelStr.trim().equals("") || levelStr.equals("#!")) {
            return null;
        }
        String[] values = levelStr.split("!");
        int index = 0;
        TreeNode root = generateNodeByString(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            curr.left = generateNodeByString(values[index++]);
            curr.right = generateNodeByString(values[index++]);
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return root;
    }
    private static TreeNode generateNodeByString(String value) {
        if ("#".equals(value)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(value));
        }
    }
}
