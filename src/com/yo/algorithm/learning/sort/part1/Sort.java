package com.yo.algorithm.learning.sort.part1;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Yo on 2017/2/6.
 * 排序算法：八大经典排序算法（冒泡、选择、插入、归并、快排、堆、希尔、计数）以及基数排序，其中计数排序和基数排序基于桶排序（一种思想）
 */
public class Sort {
    public static void main(String[] args) {
        int[] data = {2,1,4,3,6,5,8,7,10,9};
        //print
        printArray(radixSort(data, data.length));
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
    /**
     * 冒泡排序
     * @param data
     * @param len
     * @return
     */
    public static int[] bubbleSort(int[] data, int len) {
        if(data==null || len<2) {
            return data;
        }
        for(int i=0; i<len-1; i++) {
            for(int j=0; j<len-1-i; j++) {
                if(data[j] > data[j+1]) {
                    swap(data, j, j+1);
                }
            }
        }
        return data;
    }
    /**
     * 选择排序
     * @param data
     * @param len
     * @return
     */
    public static int[] selectionSort(int[] data, int len) {
        if(data==null || len<2) {
            return data;
        }
        for(int i=1; i<len; i++) {
            for(int j=i-1; j>=0; j--) {
                if(data[j] > data[j+1]) {
                    swap(data, j, j+1);
                }
            }
        }
        return data;
    }
    /**
     * 插入排序
     * @param data
     * @param len
     * @return
     */
    public static int[] insertionSort(int[] data, int len) {
        if (data == null || len < 2) {
            return data;
        }
        int i, j, max;
        for(i=1; i<len; i++) {
            max = data[i];
            for(j=i; j>0 && max<data[j-1]; j--) {
                data[j] = data[j-1];
            }
            data[j] = max;
        }
        return data;
    }
    /**
     * 归并排序
     * @param data
     * @param len
     * @return
     */
    public static int[] mergeSort(int[] data, int len) {
        sort(data, 0, len-1);
        return data;
    }
    /**
     * 排序合并
     * @param data
     * @param left
     * @param right
     */
    public static void sort(int[] data, int left, int right) {
        if(left < right) {
            int middle = (left+right)/2;
            sort(data, left, middle);
            sort(data, middle+1, right);
            merge(data, left, middle, right);
        }
    }
    /**
     * 合并
     * @param data
     * @param left
     * @param middle
     * @param right
     */
    public static void merge(int[] data, int left, int middle, int right) {
        int[] tempArr = new int[right-left+1];
        int leftIndex = left;
        int rightIndex = middle+1;
        int tempIndex = 0;

        while(leftIndex<=middle && rightIndex<=right) {
            if(data[leftIndex] < data[rightIndex]) {
                tempArr[tempIndex++] = data[leftIndex++];
            } else {
                tempArr[tempIndex++] = data[rightIndex++];
            }
        }
        while(leftIndex <= middle) {
            tempArr[tempIndex++] = data[leftIndex++];
        }
        while(rightIndex <= right) {
            tempArr[tempIndex++] = data[rightIndex++];
        }

        int temp = 0;
        while((left+temp) <= right) {
            data[left+temp] = tempArr[temp++];
        }
    }

    /**
     * 分区
     * @param data
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] data, int low, int high) {
        int key = data[low];

        while(low < high) {
            while(low<high && data[high]>=key) {
                high--;
            }
            data[low] = data[high];
            while(low<high && data[low]<=key) {
                low++;
            }
            data[high] = data[low];
        }
        data[low] = key;

        return low;
    }

    /**
     * 排序
     * @param data
     * @param low
     * @param high
     */
    public static void quick_sort(int[] data, int low, int high) {
        if(low < high) {
            int res = partition(data, low, high);
            quick_sort(data, low, res-1);
            quick_sort(data, res+1, high);
        }
    }

    /**
     * 快速排序
     * @param data
     * @param len
     * @return
     */
    public static int[] quickSort(int[] data, int len) {
        quick_sort(data, 0, len-1);
        return data;
    }

    /**
     * 堆排序
     * @param data
     * @param len
     * @return
     */
    public static int[] heapSort(int[] data, int len) {
        for(int i=len/2; i>=0; i--) {
            heapAdjust(data, i, len);
        }
        for(int i=len-1; i>0; i--) {
            swap(data, 0, i);
            heapAdjust(data, 0, i);
        }
        return data;
    }
    /**
     * 调整堆
     * @param data
     * @param index
     * @param length
     */
    public static void heapAdjust(int[] data, int index, int length) {
        int childLeft = index*2 + 1;
        int temp = data[index];

        while(childLeft < length) {
            if(childLeft!=length-1 && data[childLeft]<data[childLeft+1]) {
                childLeft++;
            }
            if(temp > data[childLeft]) {
                break;
            } else {
                data[index] = data[childLeft];
                index = childLeft;
                childLeft = index*2 + 1;
            }
        }
        data[index] = temp;
    }

    /**
     * 希尔排序(改进后的插入排序，步长可调整)
     * @param data
     * @param len
     * @return
     */
    public static int[] shellSort(int[] data, int len) {
        if(data==null || len<=2) {
            return data;
        }
        int feet = len/2;
        int index;
        while(feet > 0) {
            for(int i=feet; i<len; i++) {
                index = i;
                while(index>=feet && data[index]<data[index-feet]) {
                    swap(data, index-feet, index);
                    index -= feet;
                }
            }
            feet /= 2;
        }
        return data;
    }

    /**
     * 计数排序
     * @param data
     * @param len
     * @return
     */
    public static int[] countingSort(int[] data, int len) {
        if(data==null || len<2) {
            return data;
        }
        count(data, len);
        return data;
    }
    /**
     * 计数
     * @param data
     * @param len
     */
    public static void count(int[] data, int len) {
        int min = data[0];
        int max = data[0];
        for(int i=1; i<len; i++) {
            min = Math.min(data[i], min);
            max = Math.max(data[i], max);
        }

        int[] countArr = new int[max-min+1];
        for(int i=0; i<len; i++) {
            countArr[data[i]-min]++;
        }

        int index = 0;
        for(int i=0; i<countArr.length; i++) {
            if(countArr[i]-- > 0) {
                for(int j=countArr[i]; j>=0; j--) {
                    data[index++] = i+min;
                }
            }
        }
    }

    /**
     * 基数排序
     * @param data
     * @param len
     * @return
     */
    public static int[] radixSort(int[] data, int len) {
        if(data==null || len<=2) {
            return data;
        }
        int m=1, k=0, index=1;
        int[][] help = new int[10][len];
        int[] count = new int[len];
        int i, j, lsd;

       while(m++ < 4) {
           for(i=0; i<len; i++) {
               lsd = data[i]/index%10;
               help[lsd][count[lsd]++] = data[i];
           }
           for(i=0; i<len; i++) {
               if(count[i] > 0) {
                   for(j=0; j<count[i]; j++) {
                       data[k++] = help[i][j];
                   }
               }
               count[i] = 0;
           }
           k = 0;
           index *= 10;
       }

        return data;
    }

}