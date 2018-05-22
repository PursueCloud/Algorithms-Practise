package com.yo.algorithm.practise.cig.stackqueue.practise;

import com.yo.algorithm.practise.cig.stackqueue.maxtree8.impl.structure.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxTree {

    public static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i=0; i<arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        Map<Node, Node> leftBigMap = new HashMap<>();
        Map<Node, Node> rightBigMap = new HashMap<>();
        //求每个数往左第一个比它大的数并记录到Map中
        for (int i=0; i<nArr.length; i++) {
            Node currNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value<currNode.value) {
                popStackSetMap(stack, leftBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, leftBigMap);
        }
        //求每个数往右第一个比它大的数并记录到Map中
        for (int i=nArr.length-1; i>-1; i--) {
            Node currNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value<currNode.value) {
                popStackSetMap(stack, rightBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rightBigMap);
        }
        Node head = null;
        for (int i=0; i<nArr.length; i++) {
            Node currNode = nArr[i];
            Node left = leftBigMap.get(currNode);
            Node right = rightBigMap.get(currNode);
            if (left==null && right==null) {
                //当前数是最大值，即根节点，因为其左边第一个比它大的数和右边第一个比它大的数不存在
                head = currNode;
            } else if (left == null) {
                //当前数左边第一个比它大的数不存在
                if (right.left == null) {
                    right.left = currNode;
                } else {
                    right.right = currNode;
                }
            } else if (right == null) {
                //当前数右边第一个比它大的数不存在
                if (left.left == null) {
                    left.left = currNode;
                } else {
                    left.right = currNode;
                }
            } else {
                //当前数左边第一个比它大的数和右边第一个比它大的数都存在，故选出较小的一个作为其根节点
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
        Node currNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(currNode, null);
        } else {
            map.put(currNode, stack.peek());
        }
    }
}
