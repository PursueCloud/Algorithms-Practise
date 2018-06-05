package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.practise;

import java.util.Stack;

/**
 *  思路：
 *      一个栈stackIn负责入队，另一个栈stackOut负责出队。当stackOut为空时，一次性把stackIn中的元素全部压入stackOut
 *  解法：
 *      如思路所述，但要注意：
 *                      1、stackOut不为空时，不能往将stackIn中元素压入stackOut
 *                      2、必须一次性把stackIn中元素压入stackOut，否则会出现元素出队顺序错乱。比如，1入队，将1压入stackOut；2入队，
 *                      2压入stackOut。则出队顺序变为2 -》 1，导致不符合队列特征
 */
public class TwoStackQueue<T> {
    private final Stack<T> stackIn;
    private final Stack<T> stackOut;

    public TwoStackQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void add(T newElem) {
        stackIn.push(newElem);
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty!");
        }
        moveAllElementsToStackOut();
        return stackOut.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty!");
        }
        moveAllElementsToStackOut();
        return stackOut.peek();
    }

    private void moveAllElementsToStackOut() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return stackIn.size() + stackOut.size();
    }

    public static <E> TwoStackQueue newInstance() {
        return new TwoStackQueue<E>();
    }
}
