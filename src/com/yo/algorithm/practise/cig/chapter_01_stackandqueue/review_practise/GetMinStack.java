package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.review_practise;

import java.util.Stack;

/**
 * 回顾：
 *      思路：
 *          两个栈，一个栈dataStack用来存数据，另一个minStack用来存每一次入栈时最小的数据
 *      解法：
 *          1、入栈时，判断minStack是否为空或当前入栈元素比minStack栈顶元素小或相等，如果是，则将元素压入minStack中；否则，不压入。
 *             出栈时，判断出栈元素是否与minStack栈顶元素相等，如果是，则将minStack栈顶元素出栈，然后将dataStack栈顶元素
 *             出栈；否则，minStack不出栈，dataStack栈顶元素出栈
 *          2、入栈时，判断minStack是否为空或当前入栈元素比minStack栈顶元素小或相等，如果是，则将元素压入minStack中，否则，重复压入
 *            minStack栈顶元素到minStack。
 *             出栈时，直接弹出minStack和dataStack栈顶元素
 */
public class GetMinStack<T> {
    private final Stack<T> dataStack;
    private final Stack<T> minStack;

    public GetMinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(T newElem) {
        if (minStack.empty() || ((Comparable) newElem).compareTo(minStack.peek())<=0) {
            minStack.push(newElem);
        }
        dataStack.push(newElem);
    }

    public T pop() {
        if (dataStack.empty()) {
            throw new IllegalStateException("stack is empty!");
        }
        T popElem = dataStack.pop();
        if (!minStack.empty() && ((Comparable)popElem).compareTo(minStack.peek()) == 0) {
            minStack.pop();
        }
        return popElem;
    }

    public void push2(T newElem) {
        if (minStack.empty() || ((Comparable) newElem).compareTo(minStack.peek())<=0) {
            minStack.push(newElem);
        } else {
            if (!minStack.empty()) {
                minStack.push(minStack.peek());
            }
        }
        dataStack.push(newElem);
    }

    public T pop2() {
        if (dataStack.empty()) {
            throw new IllegalStateException("stack is empty!");
        }
        T popElem = dataStack.pop();
        if (!minStack.empty()) {
            minStack.pop();
        }
        return popElem;
    }

    public T getMin() {
        if (minStack.empty()) {
            throw new IllegalStateException("stack is empty!");
        }
        return minStack.peek();
    }

    public boolean isEmpty() {
        return this.dataStack.empty();
    }

    public int size() {
        return this.dataStack.size();
    }
    public boolean hasMin() {
        return !this.minStack.empty();
    }

    public static <E> GetMinStack newInstance() {
        return new GetMinStack<E>();
    }
}
