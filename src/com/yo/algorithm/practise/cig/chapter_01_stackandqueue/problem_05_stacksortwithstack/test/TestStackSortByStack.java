package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_05_stacksortwithstack.test;

import com.yo.algorithm.practise.cig.chapter_01_stackandqueue.practise.StackSortByAnotherStack;

import java.util.Stack;

/**
 * 测试 -- 用一个栈实现另一个栈的排序
 */
public class TestStackSortByStack {

    /**
    <pre>
        测试结果：
            排序前，栈的顺序（从后往前分布对应栈顶到栈底）为：[2, 3, 5, 1, 6, 4, 10, 11, 9, 7]
            排序后，栈的顺序（从后往前分布对应栈顶到栈底）为：[1, 2, 3, 4, 5, 6, 7, 9, 10, 11]
        总结：
            实现原理：1、申请一个辅助栈help；2、遍历stack（当stack不为空时），每次弹出栈顶元素curr，将其与help中栈顶元素top对比，如果help为空或curr <= top，则将curr压入help中；否则，先将help中所有元素重新压入stack中，然后将curr压入help中。
                    3、循环第2步，知道stack所有元素均已压入help中，此时help元素从栈顶到栈底已经为有序（升序）；4、将help中所有元素重新压入stack，即实现stack从栈顶到栈底降序
            分析：实现原理中的第2步，保证了help中的元素顺序从栈顶到栈底总是从小到大，因为每次往help中压入的元素都是比此时help栈顶元素要小或相等的，否则就会将help中所有元素重新
                 压入stack并将刚刚stack中弹出的元素（即用于与help中栈顶元素进行比较的元素）压入help

     </pre>
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 6, 4, 10, 11, 9, 7};
        Stack<Integer> stack = new Stack<>();
        for (int element : arr) {
            stack.push(element);
        }
        System.out.println("排序前，栈的顺序（从后往前分布对应栈顶到栈底）为：" + stack);
        StackSortByAnotherStack.sort(stack);
        System.out.println("排序后，栈的顺序（从后往前分布对应栈顶到栈底）为：" + stack);
    }
}
