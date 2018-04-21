package com.yo.algorithm.learning.sort.part3;

/**
 *
 有序矩阵查找练习题
     现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
     给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
     测试样例：
     [[1,2,3],[4,5,6],[7,8,9]],3,3,10
     返回：false
 * Created by Yo on 2017/2/22.
 */
public class Finder {
    public static void main(String[] args) {
        int[][] data = {{1,2,3}, {4,5,6}, {7,8,9}};
        //print
        System.out.println(findsX(data, data.length, data[0].length, 9));
    }
    /**
     * 打印数组（每个元素）
     * @param data
     */
    public static void printArray(int[] data) {
        System.out.print("排序后的数据： ");
        for(int a : data) {
            System.out.print(a + " ");
        }
    }

    /**
     *
     * @param matrix
     * @param n 行数
     * @param m 列数
     * @param x
     * @return
     */
    public static boolean findsX(int[][] matrix, int n, int m, int x) {
        int row = 0;
        int col = m - 1;
        while( row<n && col>=0 ) {
            if( matrix[row][col] == x ) {
                return true;
            } else {
                //如果比当前数更大说明该列的所有数都比x大，左移；否则下移
                if( matrix[row][col] > x ) {
                    col--;
                } else {
                    row++;
                }
            }
        }
        return false;
    }
}
