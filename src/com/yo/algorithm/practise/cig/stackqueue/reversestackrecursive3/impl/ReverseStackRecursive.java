package com.yo.algorithm.practise.cig.stackqueue.reversestackrecursive3.impl;

import java.util.Stack;

/**
 * 仅用递归和栈操作反转栈元素
 */
public class ReverseStackRecursive {

    public static <T> T getAndRemoveLastElement(Stack<T> stack) {
        //从栈中弹出一个元素
        T result = stack.pop();
        if (stack.isEmpty()) {
            //如果栈已经为空，则表明刚刚弹出的元素是栈底元素，直接返回该元素
            return result;
        } else {
            //如果当前元素不是栈底元素，则递归获取栈底元素
            T last = getAndRemoveLastElement(stack);
            //重新压入（栈底元素的）上一个元素
            stack.push(result);
            return last;
        }
    }

    public static <T> void reverse(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        //获取栈底元素
        T last = getAndRemoveLastElement(stack);
        //递归反转栈（获取栈底元素并将其重新压入栈中）
        reverse(stack);
        //将栈底元素重新压入栈中（由于第一个栈底元素是递归中的顶层调用，所以它会在最后才被压入栈中。
        //每次递归获取栈底元素并重新压入，而前一个栈底元素会在当前栈底元素被取出并入栈中才会被入栈，所以最后才能实现反转）
        stack.push(last);
    }
}
