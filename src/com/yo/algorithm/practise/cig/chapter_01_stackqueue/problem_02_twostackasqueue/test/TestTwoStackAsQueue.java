package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_02_twostackasqueue.test;

import com.yo.algorithm.practise.cig.chapter_01_stackqueue.practise.TwoStackQueue;
import com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_02_twostackasqueue.impl.TwoStackAsQueue;

import java.util.Arrays;

/**
 * 测试 -- 两个栈组成的队列
 */
public class TestTwoStackAsQueue {

    /**
     <pre>
        测试结果：
            original data1 : [1, 2, 3]
            data show in queue : [3, 2, 1]
            original data2 : [4, 5, 6]
            data show in queue : [6, 5, 4, 3, 2, 1]
            6 5 4 3 2 1
        总结：
            实现原理：一个栈stackIn负责压入数据，一个栈stackOut负责取出数据，取出数据之前必须把stackIn中的数据压进stackOut中。由于栈的特点是先进先出，所以当stackIn中的数据压入stackOut中之后，数据取出顺序会变成鱼压入的顺序一样，即先进先出
            注意事项：1、stackIn中的数据必须一次性压入stackOut中；2、当stackOut不为空时，stackIn不能向其中压入数据。否则会出现数据取出顺序错误
            （错误举例：
                1、数据取出顺序不能保证跟其压入顺序一样，比如当压入1到stackIn时，stackOut也压入了1；压入2到stackIn时，stackOut也压入了2。此时从stackOut中取出数据顺序就变成了：2，1；
                2、一次性压入1，2，3到stackIn，压入完成后stackOut一次性压入3，2，1；然后stackIn再一次性压入4，5，6，stackOut再一次性压入6，5，4。此时，从stackOut中取出数据顺序就变成了：4，5，6，1，2，3
            ）
     </pre>
     **/
    public static void main(String[] args) {
        TwoStackAsQueue<Integer> queue = TwoStackAsQueue.newInstance();
        //测试数据1
        int[] arr1 = {1, 2, 3};
        //压入所有测试数据
        for (int element : arr1) {
            queue.add(element);
        }
        System.out.println("original data1 : " + Arrays.toString(arr1));
        System.out.println("data show in queue : " + queue);
        pollQueueAndPrint(queue);
        //测试数据2
        int[] arr2 = {4, 5, 6};
        //压入所有测试数据
        for (int element : arr2) {
            queue.add(element);
        }
        System.out.println("original data2 : " + Arrays.toString(arr2));
        System.out.println("data show in queue : " + queue);
        pollQueueAndPrint(queue);
    }

    public static void pollQueueAndPrint(TwoStackAsQueue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
    public static void pollQueueAndPrint(TwoStackQueue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
