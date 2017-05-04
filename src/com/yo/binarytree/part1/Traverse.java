package com.yo.binarytree.part1;

/**
 * 二叉树遍历(递归和非递归
   请用递归方式实现二叉树的先序、中序和后序的遍历打印。
   给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 * Created by Yo on 2017/2/26.
 */

import com.yo.binarytree.datastructure.TreeNode;

import java.util.*;

/**
 * 遍历方法
 */
public class Traverse {
    public static void main(String[] args) {
        /*
                     1
                 2       3
              4     5  6    7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        //先序：1 2 4 5 3 6 7
        System.out.print("先序：");
//        preOrderTraverse_recursive(root, null);
        preOrderTraverse_unRecursive(root);
        System.out.println();
        System.out.print("中序：");
        //终序：4 2 5 1 6 3 7
//        midOrderTraverse_recursive(root, null);
        midOrderTraverse_unRecursive(root);
        System.out.println();
        System.out.print("后序：");
        //后序：4 5 2 6 7 3 1
//        lastOrderTraverse_recursive(root, null);
        lastOrderTraverse_unRecursive(root);
        System.out.println("\n节点数：" + getTreeNodeCnt(root));
        int[][] res = convert(root);
        System.out.println(res);
    }
    public static int[][] convert(TreeNode root) {
        return convert_unRecursive(root);
    }
//--------------------------递归方法
    public static int[][] convert_recursive(TreeNode root) {
        int[][] res = new int[3][];
        //获取前、总、后序三种遍历方式的遍历结果
        List<Integer> preResList = new ArrayList<Integer>();
        preOrderTraverse_getVals_recursive(root, preResList);
        List<Integer> midResList = new ArrayList<Integer>();
        midOrderTraverse_getVals_recursive(root, midResList);
        List<Integer> afterResList = new ArrayList<Integer>();
        lastOrderTraverse_getVals_recursive(root, afterResList);

        int[] preRes = new int[preResList.size()];
        for(int i=0; i<preResList.size(); i++) {
            preRes[i] = preResList.get(i);
        }
        int[] midRes = new int[midResList.size()];
        for(int i=0; i<midResList.size(); i++) {
            midRes[i] = midResList.get(i);
        }
        int[] afterRes = new int[afterResList.size()];
        for(int i=0; i<afterResList.size(); i++) {
            afterRes[i] = afterResList.get(i);
        }
        res[0] = preRes;
        res[1] = midRes;
        res[2] = afterRes;
        return res;
    }
    /**
     * 先序遍历（递归）
     * @param root
     */
    public static void preOrderTraverse_getVals_recursive(TreeNode root, List<Integer> values) {
        if( root == null ) {
            return;
        }
        System.out.print(root.value + " ");//直接打印头结点的值
        if( values != null ) {
            values.add(root.value);
        }
        preOrderTraverse_getVals_recursive(root.left, values);//再遍历左子树
        preOrderTraverse_getVals_recursive(root.right, values);//最后遍历右子树
    }
    /**
     * 中序遍历（递归）
     * @param root
     */
    public static void midOrderTraverse_getVals_recursive(TreeNode root, List<Integer> values) {
        if( root == null ) {
            return;
        }
        midOrderTraverse_getVals_recursive(root.left, values);//先遍历左子树
        System.out.print(root.value + " ");//然后打印头结点的值
        if( values != null ) {
            values.add(root.value);
        }
        midOrderTraverse_getVals_recursive(root.right, values);//最后遍历右子树
    }
    /**
     * 后序遍历（递归）
     * @param root
     */
    public static void lastOrderTraverse_getVals_recursive(TreeNode root, List<Integer> values) {
        if( root == null ) {
            return;
        }
        lastOrderTraverse_getVals_recursive(root.left, values);//先遍历左子树
        lastOrderTraverse_getVals_recursive(root.right, values);//然后遍历右子树
        System.out.print(root.value + " ");//最后打印头结点的值
        if( values != null ) {
            values.add(root.value);
        }
    }
    /**
     * 先序遍历（递归）
     * @param root
     */
    public static void preOrderTraverse_print_recursive(TreeNode root) {
        if( root == null ) {
            return;
        }
        System.out.print(root.value + " ");//直接打印头结点的值
        preOrderTraverse_print_recursive(root.left);//再遍历左子树
        preOrderTraverse_print_recursive(root.right);//最后遍历右子树
    }
    /**
     * 中序遍历（递归）
     * @param root
     */
    public static void midOrderTraverse_print_recursive(TreeNode root) {
        if( root == null ) {
            return;
        }
        midOrderTraverse_print_recursive(root.left);//先遍历左子树
        System.out.print(root.value + " ");//然后打印头结点的值
        midOrderTraverse_print_recursive(root.right);//最后遍历右子树
    }
    /**
     * 后序遍历（递归）
     * @param root
     */
    public static void lastOrderTraverse_print_recursive(TreeNode root) {
        if( root == null ) {
            return;
        }
        lastOrderTraverse_print_recursive(root.left);//先遍历左子树
        lastOrderTraverse_print_recursive(root.right);//然后遍历右子树
        System.out.print(root.value + " ");//最后打印头结点的值
    }
    /**
     * 获取树节点数（递归）
     * @param root
     * @return
     */
    public static int getTreeNodeCnt(TreeNode root) {
        if( root == null ) {
            return 0;
        }
        int cnt = 1;
        if( root.left != null ) {
            cnt += getTreeNodeCnt(root.left);
        }
        if( root.right != null ) {
            cnt += getTreeNodeCnt(root.right);
        }
        return cnt;
    }
    /**
     * 生成树节点值数组
     * @param root
     * @param resList
     * @return
     */
    public static int[] generateOrderResArray(TreeNode root, List<TreeNode> resList) {
        if( root==null || resList==null) {
            return null;
        }
        //构造返回结果
        int[] res = new int[getTreeNodeCnt(root)];
        for(int i=0; i<resList.size(); i++) {
            TreeNode node = resList.get(i);
            System.out.print(node.value + " ");
            res[i] = node.value;
        }
        return res;
    }
//--------------------------非递归方法
    public static int[][] convert_unRecursive(TreeNode root) {
        if( root == null ){
            return null;
        }
        int[][] res = new int[3][];
        res[0] = preOrderTraverse_unRecursive(root);
        res[1] = midOrderTraverse_unRecursive(root);
        res[2] = lastOrderTraverse_unRecursive(root);

        return res;
    }
    /**
     * 先序遍历（非递归）
     * @param root
     */
    public static int[] preOrderTraverse_unRecursive(TreeNode root) {
        if( root == null ) {
            return null;
        }
        if( root == null ) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<TreeNode> preList = new ArrayList<TreeNode>();
        TreeNode temp = null;
        while( !stack.isEmpty() ) {
            temp = stack.pop();
            preList.add(temp);
            if( temp.right != null ) {//先压入右节点
                stack.push(temp.right);
            }
            if( temp.left != null ) {//再压入左节点
                stack.push(temp.left);
            }
        }
        //构造返回结果
        return generateOrderResArray(root, preList);
    }
    /**
     * 中序遍历（非递归）
     * @param root
     */
    public static int[] midOrderTraverse_unRecursive(TreeNode root) {
        if( root == null ) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<TreeNode> midList = new ArrayList<TreeNode>();
        TreeNode temp = root;
        while( !stack.isEmpty() ) {
            while( temp != null ) {
                temp = temp.left;
                if( temp != null ) {
                    stack.push(temp);
                }
            }
            temp = stack.pop();
            midList.add(temp);
            temp = temp.right;
            if( temp != null ) {
                stack.push(temp);
            }
        }
        //构造返回结果
        return generateOrderResArray(root, midList);
    }
    /**
     * 后序遍历（非递归）
     * @param root
     */
    public static int[] lastOrderTraverse_unRecursive(TreeNode root) {
        if( root == null ) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        List<TreeNode> lastList = new ArrayList<TreeNode>();
        TreeNode temp = null;
        while( !stack1.isEmpty() ) {
            temp = stack1.pop();
            if( temp.left != null ) {
                stack1.push(temp.left);
            }
            if( temp.right != null ) {
                stack1.push(temp.right);
            }
            stack2.push(temp);
        }
        while( !stack2.isEmpty() ) {
            lastList.add(stack2.pop());
        }
        //构造返回结果
        return generateOrderResArray(root, lastList);
    }

    enum OrderType{
        preOrder(0), midOrder(1), lastOrder(2);
        int value;
        private OrderType(int value) {
            this.value = value;
        }
    }

    /**
     * 根据根节点和遍历方式返回遍历后的树节点集合
     * @param root
     * @param orderType
     * @return
     */
    public static List<TreeNode> treeOrder(TreeNode root, Enum orderType) {
        if( root == null ) {
            return null;
        }
        List<TreeNode> resList = new ArrayList<TreeNode>();
        if(orderType == OrderType.preOrder) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode temp = null;
            while( !stack.isEmpty() ) {
                temp = stack.pop();
                resList.add(temp);
                if( temp.right != null ) {
                    stack.push(temp.right);
                }
                if( temp.left != null ) {
                    stack.push(temp.left);
                }
            }
        } else if(orderType == OrderType.midOrder) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode temp = root;
            while( !stack.isEmpty() ) {
                while( temp != null ) {
                    temp = temp.left;
                    if( temp != null ) {
                        stack.push(temp);
                    }
                }
                temp = stack.pop();
                resList.add(temp);
                temp = temp.right;
                if( temp != null ) {
                    stack.push(temp);
                }
            }
        } else if(orderType == OrderType.lastOrder) {
            Stack<TreeNode> stack1 = new Stack<TreeNode>();
            Stack<TreeNode> stack2 = new Stack<TreeNode>();
            TreeNode temp = root;
            while( !stack1.isEmpty() ) {
                temp = stack1.pop();
                if( temp.left != null ) {
                    stack1.push(temp.left);
                }
                if( temp.right != null ) {
                    stack1.push(temp.right);
                }
                stack2.push(temp);
            }
            while( !stack2.isEmpty() ) {
                resList.add(stack2.pop());
            }
        }

        return resList;
    }

}
