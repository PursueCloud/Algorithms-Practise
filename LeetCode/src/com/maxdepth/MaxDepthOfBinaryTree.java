package com.maxdepth;

import java.util.concurrent.ConcurrentLinkedQueue;

public class MaxDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(2);
		TreeNode leftChild = new TreeNode(3);
		left.left = leftChild;
		TreeNode leftChildChild = new TreeNode(3);
		leftChildChild.left = new TreeNode(2);
		leftChild.left = leftChildChild;
		root.left = left;
		root.right = right;
		System.out.println(maxDepth2(root));
	}
	
//	static int depth = 1;
//    public static int maxDepth(TreeNode root) {
//    	if(root != null) {
//	        if(root.left!=null || root.right!=null) {
//	            depth++;
//	            if(root.left!=null)
//	                return maxDepth(root.left);
//	            else if(root.right!=null)
//	                return maxDepth(root.right);
//	            return 1;
//	        } else
//	            return depth;
//    	}
//    	return 0;
//    }
	
	/**
	 * DFS思想，使用递归
	 */
	public static int maxDepth(TreeNode root) {
		if(null == root) {
			return 0;
		}
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		
		return l > r ? l+1 : r+1;
	}
	/**
	 * BFS思想,使用队列
	 */
	public static int maxDepth2(TreeNode root) {
		if(null == root) {
			return 0;
		}
		ConcurrentLinkedQueue<TreeNode> q = new ConcurrentLinkedQueue<TreeNode>();
		int nCount = 1;//记录队列里面每一层上的元素个数
		int nDepth = 0;
		
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode tempNode = q.poll();
			q.peek();
			nCount--;
			
			if(tempNode.left != null) {
				q.add(tempNode.left);
			}
			if(tempNode.right != null) {
				q.add(tempNode.right);
			}
			
			if(nCount == 0) {
				nDepth++;
				nCount = q.size();
			}
		}
		return nDepth;
	}
}
/**
 * 二叉树
 * @author Yo
 *
 */
class TreeNode {
    int val;
    TreeNode left;//左子树
    TreeNode right;//右子树
    TreeNode(int x) { 
    	this.val = x; 
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
