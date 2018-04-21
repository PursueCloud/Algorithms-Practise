package com.yo.algorithm.binarytree.part4;

import com.yo.algorithm.binarytree.datastructure.TreeNode;

import java.util.Stack;

/**寻找错误结点练习题：
   一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。
   给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 * Created by Yo on 2017/3/9.
 */
public class FindErrorNode {
    public static int[] findError(TreeNode root) {
        /*
        二叉搜索树的中序遍历，依次出现的值会一直升序，如果两个节点值错了，那么会出现降序。
        第一个错误节点为第一次降序时较大的节点，第二个错误节点是最后一次降序时较小的节点。
        该程序是一个改写的中序遍历。（用非递归模式）
        */
        int[] res = new int[2];
        TreeNode[] err = new TreeNode[2];
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur=root, point = null;//栈顶弹出的元素，是用来比较的第一个元素
        while( !stack.isEmpty() || cur!=null ) {
            if( cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if( point!=null && point.value>cur.value ) {
                    err[0] = err[0]==null ? point : err[0];
                    err[1] = cur;
                }
                point = cur;
                cur = cur.right;
            }
        }

        res[1] = err[0].value;
        res[0] = err[1].value;
        return res;
    }

}
