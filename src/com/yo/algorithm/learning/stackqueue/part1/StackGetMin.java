package com.yo.algorithm.learning.stackqueue.part1;

import java.util.Stack;

/**可查询最值的栈练习题：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
 * 解题思路：
 */
public class StackGetMin {
    public void main(String[] args) {

    }
}
/**
 * Created by Yo on 2017/3/4.
 */
class StackWithGetMin1 {//入栈稍省空间，出栈稍费时间
    Stack<Integer> stackData = new Stack<Integer>();
    Stack<Integer> stackMin = new Stack<Integer>();

    public void push(int node) {
        stackData.push(node);
        if( stackMin.isEmpty() || node<=stackMin.peek() ) {//当且仅当lastMin为空或data<=当前最小值时才压入到stackMin
            stackMin.push(node);
        }
    }

    public int pop() {
        Integer lastMin = stackMin.peek();
        int dataTop = stackData.pop();
        if( dataTop == lastMin ) {//当且仅当弹出的data==当前最小值时才弹出stackMin栈顶元素
            stackMin.pop();
        }
        return dataTop;
    }

    public int top() {
        if( stackData.isEmpty() ) {
            return -1;
        }
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}

class StackWithGetMin2 {//入栈稍费空间，出栈稍省时间
    Stack<Integer> stackData = new Stack<Integer>();
    Stack<Integer> stackMin = new Stack<Integer>();

    public void push(int node) {
        stackData.push(node);
        if( stackMin.isEmpty() || node<stackMin.peek() ) {//当且仅当stackMin为空或data小于当前最小值时才压入stackMin中
            stackMin.push(node);
        } else {//否则重复压入当前最小值
            stackMin.push(stackMin.peek());
        }
    }

    public int pop() {
        stackMin.pop();//stackMin和stackData同步弹出
        return stackData.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}