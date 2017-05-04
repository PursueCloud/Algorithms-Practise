package com.yo.binarytree.part3;

import com.yo.binarytree.datastructure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**完全二叉树判断练习题：
   有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
   给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 * Created by Yo on 2017/3/9.
 */
public class CheckCompletion {
    public static void main(String[] args) {

    }

    public static boolean chk(TreeNode root) {
        //层次遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean pan = true;
        queue.add(root);
        while( !queue.isEmpty() ) {
            root = queue.poll();
            //如果有右没左直接返回false
            if( root.right!=null && root.left==null ) {
                return false;
            }

            //如果节点的左右节点不全有，必须是叶子节点，其他返回false
            if( !pan && ( root.left!=null || root.right!=null ) ) {
                return false;
            }
            //都满足的添加进去
            if( root.left != null ) {
                queue.add(root.left);
            } else {
                pan = false;
            }
            if( root.right != null ) {
                queue.add(root.right);
            } else {
                pan = false;
            }
        }
        return true;
    }
}
