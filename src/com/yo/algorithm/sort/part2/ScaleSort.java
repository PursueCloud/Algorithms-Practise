package com.yo.algorithm.sort.part2;

/**
 * 小范围排序
     题目：
     已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
     给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
     测试样例：
     [2,1,4,3,6,5,8,7,10,9],10,2
     返回：[1,2,3,4,5,6,7,8,9,10]
 * Created by Yo on 2017/2/22.
 */
public class ScaleSort {
    public static void main(String[] args) {
        int[] data = {2,1,4,3,6,5,8,7,10, 9};
        //print
        printArray(sortElement(data, data.length, 2));
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
     * 交换元素
     * @param data
     * @param m
     * @param n
     */
    public static void swap(int[] data, int m, int n) {
        int swap = data[m];
        data[m] = data[n];
        data[n] = swap;
    }

    public static int[] sortElement(int[] data, int n, int k) {
        if( data==null || n<=2 ) {
            return data;
        }
        int[] arr = new int[n];
        int i, j = 0;
        for (i = k/2 -1; i >= 0; i--) {
            heapAdjust(data, i, k);
        }
        for(i=k; i<n; i++, j++) {
            arr[j] = data[0];
            data[0] = data[i];
            heapAdjust(data, 0, k);
        }
        for(i=k-1; i>=0; i--, j++) {
            arr[j] = data[0];
            swap(data, 0, i);
            heapAdjust(data, 0, i);
        }
        return arr;
    }
    public static void heapAdjust(int[] data, int index, int length) {
        int childLeft = index*2 + 1;
        while(childLeft < length) {
            if( childLeft<length-1 && data[childLeft]>data[childLeft+1] ) {
                childLeft++;
            }
            if( data[index] <= data[childLeft] ) {
                break;
            } else {
                swap(data, index, childLeft);
                index = childLeft;
                childLeft=index*2+1;
            }
        }
    }

}
