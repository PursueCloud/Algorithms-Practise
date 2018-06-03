package com.yo.algorithm.practise.cig.chapter_01_stackqueue.practise;

import java.util.Stack;

/**
 * 思路：
 *      1、实现一个getLastElement的方法
 *      2、递归调用getLastELement获取最后栈最后一个元素，然后将元素重新压入栈中
 * 解法：
 *      如思路所述
 *
 */
public class ReverseStack {

    /**
     * 获取栈底元素
     * @param stack
     * @param <T>
     * @return
     */
    private static <T> T getLastElement(Stack<T> stack) {
        T popElem = stack.pop();
        if (stack.empty()) {
            return popElem;
        } else {
            T result = getLastElement(stack);
            stack.push(popElem);
            return result;
        }
    }

    public static <T> void reverse(Stack<T> stack) {
        if (stack.empty()) {
            return;
        }
        T lastElem = getLastElement(stack);
        reverse(stack);
        stack.push(lastElem);
    }
}
