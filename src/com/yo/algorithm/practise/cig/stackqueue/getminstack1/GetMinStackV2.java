package com.yo.algorithm.practise.cig.stackqueue.getminstack;

import java.util.Stack;

/**
 * 有getMin功能的栈（待压入的数据必须是已经实现了Comparable接口的类型，用于比较元素大小）
 * 所有操作的时间复杂度：O（1），即常数复杂度；空间复杂度：O（n）
 * 优缺点：push时稍费空间(因为当新压入元素比stackMin栈顶元素大时，需要将stackMin栈顶元素重复压入stackMin)，pop时稍省时间（stackData与stackMin同步取出元素，不需要判断）
 * @param <E>
 */
public class GetMinStackV2<E> {
    private final Stack<E> stackData;
    private final Stack<E> stackMin;

    public GetMinStackV2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }
    public GetMinStackV2(Stack<E> stackData, Stack<E> stackMin) {
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
        if (stackData.size() == stackData.capacity()) {
            throw new IllegalStateException("stack is full!");
        }
        if (newElement == null) {
            throw new IllegalArgumentException("element to be pushed can not be null!");
        }
        if (stackMin.isEmpty() || ((Comparable)newElement).compareTo(getMin())<=0) {
            //stackMin为空或当前待压入元素<=stackMin栈顶（最小值），则将newNum压入stackMin
            stackMin.push(newElement);
        } else {
            //否则，将stackMin栈顶元素重复压入stackMin
            stackMin.push(getMin());
        }
        stackData.push(newElement);
    }

    public E pop() {
        if (stackData.empty()) {
            throw new IllegalStateException("stack is empty!");
        }
        //stackData与stackMin同步取出元素
        E popNum = stackData.pop();
        stackMin.pop();
        return popNum;
    }

    public static <T> GetMinStackV2<T> newInstance() {
        return new GetMinStackV2<>();
    }
}
