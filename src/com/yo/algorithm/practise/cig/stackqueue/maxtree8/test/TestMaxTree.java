package com.yo.algorithm.practise.cig.stackqueue.maxtree8.test;

import com.yo.algorithm.practise.cig.stackqueue.maxtree8.impl.MaxTree;
import com.yo.algorithm.practise.cig.stackqueue.maxtree8.impl.structure.Node;

public class TestMaxTree {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        Node maxTree = MaxTree.getMaxTree(arr);
        System.out.println(maxTree);
    }
}
