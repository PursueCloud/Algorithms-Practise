package com.yo.algorithm.practise.cig.stackqueue.maxtree8.test;

import com.yo.algorithm.practise.cig.stackqueue.maxtree8.impl.structure.Node;

public class TestMaxTree {
    /**
     * 测试结果（{3, 4, 5, 1, 2}）：
     *      5
     *    /  |
     *   4    2
     *  /    /
     * 3    1
     * 测试结果（{3, 1, 2}）：
     *      3
     *    /
     *   2
     *  /
     * 1
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        Node maxTree1 = com.yo.algorithm.practise.cig.stackqueue.practise.MaxTree.getMaxTree(arr1);
        System.out.println(maxTree1);
        int[] arr2 = {3, 1, 2};
        Node maxTree2 = com.yo.algorithm.practise.cig.stackqueue.practise.MaxTree.getMaxTree(arr2);
        System.out.println(maxTree2);
    }
}
