package com.yo.binarytree.part3;

import com.yo.binarytree.datastructure.TreeNode;

/**平衡二叉树判断练习题:
   有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
   给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 * Created by Yo on 2017/3/9.
 */
public class CheckBalance {
    public static void main(String[] args) {

    }

    public static boolean check(TreeNode root) {
        return chk(root)>=0;
    }
    private static int chk(TreeNode root) {
        if( root == null ) {
            return 0;
        }
        int l=chk(root.left), r=chk(root.right);//左右两边深度
        if( l<0 || r<0 ) {
            return -1;
        }
        if( Math.abs(r-l) > 1 ) {
            return -1;//当左右两边深度差超过1时 返回-1
        }
        return r>l ? r+1 : l+1;
    }

}
