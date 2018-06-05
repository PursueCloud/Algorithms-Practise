package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_01_getminstack.impl;

import java.util.Stack;

/**
 * 有getMin功能的栈（待压入的数据必须是已经实现了Comparable接口的类型，用于比较元素大小）
 * 所有操作的时间复杂度：O（1），即常数复杂度；空间复杂度：O（n）
 * 优缺点：push时稍省空间（因为当新压入元素比stackMin栈顶元素大时，不需要将其压入stackMin），pop时稍费时间（因为需要判断stackData弹出元素是否比stackMin栈顶元素小）
 * @param <E>
 */
public class GetMinStackV1<E> {
    private final Stack<E> stackData;
    private final Stack<E> stackMin;

    public GetMinStackV1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }
    public GetMinStackV1(Stack<E> stackData, Stack<E> stackMin) {
        this.stackData = stackData;
        this.stackMin = stackMin;
    }

    public int size() {
        return stackData.size();
    }

    public boolean isEmpty() {
        return stackData.size() == 0;
    }

    public boolean isFull() {
        return stackData.size() == stackData.capacity();
    }

    public E getMin() {
        if (stackMin.empty()) {
            throw new IllegalStateException("stack is empty!");
        }
        return stackMin.peek();
    }

    public boolean hasMin() {
        return !stackMin.empty();
    }

    public void push(E newElement) {
        if (newElement == null) {
            throw new IllegalArgumentException("element to be pushed can not be null!");
        }
        if (stackMin.isEmpty() || ((Comparable)newElement).compareTo(getMin())<=0) {
            //stackMin为空或当前待压入元素<=stackMin栈顶（最小值），则将newNum压入stackMin
            stackMin.push(newElement);
        } else {
            //否则，不压入元素到stackMin
        }
        stackData.push(newElement);
    }

    public E pop() {
        if (stackData.empty()) {
            throw new IllegalStateException("stack is empty!");
        }
        E popNum = stackData.pop();
        if (((Comparable)popNum).compareTo(getMin()) == 0) {
            //根据元素的压入规则，stackMin当前栈顶元素永远<=stackData栈顶元素，所以当且仅当stackData弹出元素==stackMin栈顶元素（最小值）时，才弹出stackMin栈顶元素
            stackMin.pop();
        } else {
            //否则，当stackData弹出元素>stackMin栈顶元素时，不弹出stackMin栈顶元素（最小值）
        }
        return popNum;
    }

    public static <T> GetMinStackV1<T> newInstance() {
        return new GetMinStackV1<>();
    }
}
