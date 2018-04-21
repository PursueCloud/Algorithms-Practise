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
        while (!stackIn.isEmpty() && stackOut.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }

    public E poll() {
        moveElements();
        if (stackOut.empty()) {
            throw new IllegalStateException("queue is empty!");
        }
        return stackOut.pop();
    }

    public E peek() {
        moveElements();
        return stackOut.peek();
    }

    public int size() {
        return stackIn.size() + stackOut.size();
    }

    public boolean isEmpty() {
        return stackIn.empty() && stackOut.empty();
    }

    public static <T> TwoStackAsQueue<T> newInstance() {
        return new TwoStackAsQueue();
    }

    @Override
    public String toString() {
        int totalSize = stackIn.size() + stackOut.size();
        if (totalSize == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int firstLen = sb.length();
        for (int i=stackOut.size()-1; i>=0; i--) {
            E e = stackOut.get(i);
            String str = e.toString();
            if (i > 0) {
                sb.append(str).append(',').append(' ');
            } else {
                sb.append(str);
            }
        }
        for (int i=stackIn.size()-1; i>=0; i--) {
            E e = stackIn.get(i);
            String str = e.toString();
            if (i > 0) {
                sb.append(str).append(',').append(' ');
            } else {
                sb.append(str);
            }
        }
        sb.append(']').toString();
        return sb.toString();
    }

}
