package com.yo.algorithm.binarytree.part2;

import com.yo.algorithm.binarytree.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yo on 2017/3/6.
 */
public class TraverseByHierarchy {
    /**
     * 测试printByHierarchy方法
     * @param root
     */
    public static void testPrintByHierarchy(TreeNode root) {
        //按层数打印如下：
        for(int[] res : TraverseByHierarchy.printByHierarchy(root)) {//遍历方法只会执行一次，这是由foreach的机制决定
            for(int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    /**
     * 按层次打印二叉树（宽(广)度优先遍历,使用队列
     * @param root
     */
    public static int[][] printByHierarchy(TreeNode root) {
        if( root == null ) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> arr = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        TreeNode last = root;
        TreeNode nLast = null;
        TreeNode temp = null;
        while( !queue.isEmpty() ) {
            temp = queue.poll();
            arr.add(temp.value);
            if( temp.left != null ) {
                queue.add(temp.left);
                nLast = temp.left;
            }
            if( temp.right != null ) {
                queue.add(temp.right);
                nLast = temp.right;
            }
            if( temp == last ) {
                ans.add(arr);
                arr = new ArrayList<Integer>();
                last = nLast;
            }
        }

        int[][] resArr = new int[ans.size()][];
        for(int i=0; i<ans.size(); i++) {
            List<Integer> currHierarchyList = ans.get(i);
            resArr[i] = new int[currHierarchyList.size()];
            for(int j=0; j<currHierarchyList.size(); j++) {
                resArr[i][j] = currHierarchyList.get(j);
            }
        }
        return resArr;
    }
}
