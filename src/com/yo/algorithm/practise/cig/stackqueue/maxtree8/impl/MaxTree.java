package com.yo.algorithm.practise.cig.stackqueue.maxtree8.impl;

import com.yo.algorithm.practise.cig.stackqueue.maxtree8.impl.structure.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 获取数组的最大生成树
 */
public class MaxTree {

    public static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i=0; i!=arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<Node>();
        Map<Node, Node> lBigMap = new HashMap<>();
        Map<Node, Node> rBigMap = new HashMap<>();
        for (int i=0; i!=nArr.length; i++) {
            Node currNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value<currNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        for (int i=nArr.length-1; i!=-1; i--) {
            Node currNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value<currNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        Node head = null;
        for (int i=0; i!=nArr.length; i++) {
            Node currNode = nArr[i];
            Node left = lBigMap.get(currNode);
            Node right = rBigMap.get(currNode);
            if (left == null && right == null) {
                head = currNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = currNode;
                } else {
                    right.right = currNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = currNode;
                } else {
                    left.right = currNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = currNode;
                } else {
                    parent.right = currNode;
                }
            }
        }

        return head;
    }
    private static void popStackSetMap(Stack<Node> stack, Map<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }
}
