package com.yo.algorithm.practise.cig.stackqueue.getminstack1.test;

import com.yo.algorithm.practise.cig.stackqueue.getminstack1.impl.GetMinStackV1;

/**
 * 测试 -- 有getMin功能的栈
 */
public class TestGetMinStack {


    /** <pre>
     *  测试结果:
            GetMinStackV1:
                size of stack : 10
                current min in stack : -10
                current min in stack after once pop : -3
                current min in stack after once pop : -2
                current min in stack after once pop : -2
                current min in stack after once pop : -2
                current min in stack after once pop : -2
                current min in stack after once pop : -1
                current min in stack after once pop : 0
                current min in stack after once pop : 1
                current min in stack after once pop : 1
            GetMinStackV2：
                size of stack : 10
                current min in stack : -10
                current min in stack after once pop : -3
                current min in stack after once pop : -2
                current min in stack after once pop : -2
                current min in stack after once pop : -2
                current min in stack after once pop : -2
                current min in stack after once pop : -1
                current min in stack after once pop : 0
                current min in stack after once pop : 1
                current min in stack after once pop : 1
        总结：
            空间换时间，使用辅助数据结构（stackMin）在push和pop操作的同时记录下每次操作的元素的最小值，以换取getMin操作时间复杂度为O（1）
     </pre>
     **/
    public static void main(String[] args) {
        GetMinStackV1<Integer> stack = GetMinStackV1.newInstance();
//        GetMinStackV2<Integer> stack = GetMinStackV2.newInstance();
        //测试数据
        int[] arr = {1, 5, 0, -1, -2, 6, 7 , 8, -3, -10};
        //压入所有测试数据
        for (int element : arr) {
            stack.push(element);
        }
        System.out.println(stack.getClass().getSimpleName() + "：");
        System.out.println("    size of stack : " + stack.size());
        System.out.println("    current min in stack : " + stack.getMin());
        while (!stack.isEmpty()) {
            stack.pop();
            if (stack.hasMin()) {
                System.out.println("    current min in stack after once pop : " + stack.getMin());
            }
        }
    }
}
