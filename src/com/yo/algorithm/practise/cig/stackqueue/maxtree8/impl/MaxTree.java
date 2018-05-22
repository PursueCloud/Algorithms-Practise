package com.yo.algorithm.practise.cig.stackqueue.maxtree8.impl;

import com.yo.algorithm.practise.cig.stackqueue.maxtree8.impl.structure.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 获取数组的最大生成树
 * 最大生成树定义：
 *      1、数组必须没有重复元素。
 *      2、MaxTree是一个二叉树，数组的每一个值对应一个二叉树节点。
 *      3、包括MaxTree数在内且在其中的每一颗子树上，值最大的节点都是输的头。
 *      4、每一个输的父节点是它左边第一个比它大的数和它邮编第一个比它大的数中，较小的一个。
 *      5、如果一个数左边没有比它大的数，右边也没有。也就是说，这个数十整个数组的最大值，那么这个数十MaxTree的头（根）节点
 * 思路：
 *      找每个数左边第一个比它大的数，从左到右遍历每个数，栈中保持递减序列，新来的数不停地利用Pop出栈顶，
 *      知道栈顶比新书大或没有数。
 *      以数组[3,1,2]为例，首先3入栈，接下来1比3小，无须pop出3，1入栈，并且确定了1往左第一个比它大的数为3。
 *      接下来2比1大，1出栈，2比3小，2入栈，并且确定了2往左第一个比它大的数为3
 * 解法：
 *      遍历数组过程中，找出一个数往左（升序遍历）和往右（倒序遍历），用两个Map存储该数往左和往右第一个比它大的数
 * 数组长度为N，则时间复杂度：O（N），空间复杂度：O（N）
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
        //找出每个数往左第一个比它大的数并存储到Map中
        for (int i=0; i<nArr.length; i++) {
            Node currNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value<currNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        //找出每个数往右第一个比它大的数并存储到Map中
        for (int i=nArr.length-1; i>-1; i--) {
            Node currNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value<currNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        //构造最大生成树
        Node head = null;
        for (int i=0; i!=nArr.length; i++) {
            Node currNode = nArr[i];
            Node left = lBigMap.get(currNode);
            Node right = rBigMap.get(currNode);
            if (left == null && right == null) {
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
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }
}
