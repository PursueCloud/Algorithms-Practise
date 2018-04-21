package com.yo.algorithm.learning.sort.part2;

/**
 * 有序数组合并
     题目：
     有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
     给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 * Created by Yo on 2017/2/22.
 */
public class Merge {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5, 7, 0, 0, 0, 0, 0, 0, 0};
        int[] B = {4, 5, 6, 9, 10, 11, 15};

        printArray(mergeAB(A, B, getRealSize(A), B.length));
    }
    public static int getRealSize(int[] data) {
        if( data==null || data.length==0 ) {
            return 0;
        }
        int realSize = 0;
        for(int d : data) {
            if( d != 0 ) {
                realSize++;
            }
        }
        return  realSize;
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
     * @param A
     * @param B
     * @param ARLen A数组的真实大小
     * @param BRLen B数据的真实大小
     * @return
     */
    public static int[] mergeAB(int[] A, int[] B, int ARLen, int BRLen) {
        int index = ARLen + BRLen - 1;
        int i = ARLen - 1;
        int j = BRLen - 1;

        while( i>=0 && j>=0 ) {
            if( A[i] >= B[j] ) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while( j >= 0 ) {
            A[index--] = B[j--];
        }
        return A;
    }

}
