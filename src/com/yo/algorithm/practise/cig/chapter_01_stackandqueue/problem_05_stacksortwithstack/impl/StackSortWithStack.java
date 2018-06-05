package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_05_stacksortwithstack.impl;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * 只能申请一个栈（其他数据结构不行），可以申请新的遍历
 */
public class StackSortWithStack {


    public static <T> void sort(Stack<T> stack) {
        if (stack == null) {
            return;
        }
        Stack<T> help = new Stack<>();
        while (!stack.isEmpty()) {
            T curr = stack.pop();
            if (help.isEmpty() || ((Comparable)curr).compareTo(help.peek())<=0) {
                //help栈为空或curr（stack栈顶元素）<= help栈顶元素时，将curr压入help栈中
                help.push(curr);
            } else if (((Comparable)curr).compareTo(help.peek()) > 0) {
                //curr（stack栈顶元素）> help栈顶元素
                while (!help.isEmpty()) {
                    //先将help中所有元素压回stack中
                    stack.push(help.pop());
                }
                //然后将curr压入help栈中
                help.push(curr);
            }
        }
        //当stack中所有元素均已压入help中时，此时help中栈顶到栈底元素已经排好序，即升序（从小到大）。故，再将help中所有元素重新压入stack中后，stack中元素即实现从栈顶到栈底倒序排列（从大到小）
        while (!help.isEmpty()) {
            //将help中所有元素压回stack中即实现stack栈顶到栈底倒序
            stack.push(help.pop());
        }
    }
}
