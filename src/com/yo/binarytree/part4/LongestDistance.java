package com.yo.binarytree.part4;

import com.yo.binarytree.datastructure.TreeNode;

/**树上最远距离练习题：
   从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
   给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 * Created by Yo on 2017/3/9.
 */
public class LongestDistance {
    public int findLongest(TreeNode root) {
        if( root == null ) {
            return -1;
        }
        return findLongestCore(root, new int[1]);


    }
    public int findLongestCore(TreeNode root,int[] res){
        if (root == null) {
            res[0] = 0;
            return 0;
        }
        int lMax = findLongestCore(root.left, res);
        int maxLeftChild = res[0];
        int rMax = findLongestCore(root.right, res);
        int maxRightChild = res[0];
        res[0] = Math.max(maxLeftChild+1, maxRightChild+1);

        return Math.max(Math.max(lMax, rMax), maxLeftChild+maxRightChild+1);
    }

}
