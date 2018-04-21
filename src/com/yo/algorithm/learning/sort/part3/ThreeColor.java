package com.yo.algorithm.learning.sort.part3;

/**
 * 三色排序
     题目：
     有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
     给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
     测试样例：
     [0,1,1,0,2,2],6
     返回：[0,0,1,1,2,2]
 * Created by Yo on 2017/2/22.
 */
public class ThreeColor {
    public static void main(String[] args) {
        int[] data = {0, 1, 1, 0, 2, 2, 0, 2, 0};
        //print
        printArray(sortThreeColor(data, data.length));
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

    static void  swap(int[] A,int m,int n){
        if(m!=n){
            int temp = A[m];
            A[m] = A[n];
            A[n] = temp;
        }
    }

    public static int[] sortThreeColor(int[] A, int n) {
        if( A==null || n<2 ) {
            return A;
        }
        int i=0, j=0, k=n-1;
        while( j <= k ) {
            if( A[j] == 0 ) {
                swap(A, i++, j++);
            } else if( A[j] == 1 ) {
                j++;
            } else {
                swap(A, j, k--);
            }
        }
        return A;
    }
}
