package com.yo.algorithm.practise.cig.stackqueue.reversestackrecursive3.test;

import com.yo.algorithm.practise.cig.stackqueue.reversestackrecursive3.impl.ReverseStackRecursive;

import java.util.Stack;

/**
 * 测试 -- 只用递归和栈操作反转单链表
 */
public class TestReverseStackRecursive {

    /**
        <pre>
            测试结果:
               Stack before reversing : [1, 2, 3]
               Stack after reversing : [3, 2, 1]
            实现原理：
               利用递归的特性（函数栈），通过递归实现一个获取栈底元素的函数，然后将栈的所有元素都取出来（放在每一次递归调用里面的局部变量里），
               最后将所有元素（此时栈中所有元素的顺序按递归的层次来看，相比原来在栈中的顺序已经反转了）递归压入栈中
        </pre>
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Stack<Integer> stack = new Stack<>();
        for (int element : arr) {
            stack.push(element);
        }
        System.out.println("Stack before reversing : " + stack);
        ReverseStackRecursive.reverse(stack);
        System.out.println("Stack after reversing : " + stack);
    }
}
