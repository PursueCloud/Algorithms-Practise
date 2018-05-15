package com.yo.algorithm.practise.cig.stackqueue.twostackasqueue2.impl;

import java.util.Stack;

/**
 * 由两个栈组成的队列
 * 时间复杂度：O（n），空间复杂度：O（n）
 */
public class TwoStackAsQueue<E> {
    private final Stack<E> stackIn;
    private final Stack<E> stackOut;

    public TwoStackAsQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void add(E newElement) {
        if (newElement == null) {
            throw new IllegalArgumentException("element to be added can not be null!");
        }
        stackIn.push(newElement);
    }

    private void moveElements() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public E poll() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty!");
        }
        moveElements();
        return stackOut.pop();
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty!");
        }
        moveElements();
        return stackOut.peek();
    }

    public int size() {
        return stackIn.size() + stackOut.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static <T> TwoStackAsQueue<T> newInstance() {
        return new TwoStackAsQueue();
    }

}
