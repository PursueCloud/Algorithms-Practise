package com.yo.algorithm.learning.stackqueue.datastructure;

/**
 * 栈
 * Created by Yo on 2017/3/4.
 */
public class MyStack {
    int[] data;
    int capacity = 10;
    int top;
    int size;
    boolean isFirst = true;

    private void initData() {
        data = new int[capacity];
    }

    public MyStack() {
        initData();
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        initData();
    }

    public void addElem(int value) {
        data[top++] = value;
        size++;
    }

    public void push(int value) throws Exception {
        if( top == size && !isFirst ) {
            int[] newData = new int[data.length + 10];
            for(int i=0; i<data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        addElem(value);
        isFirst = false;
    }

    public int pop() throws Exception {
        if( top == 0 ) {
            throw new Exception("栈已空，无法取出数据！");
        } else {
            size--;
            return data[--top];
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if( top == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        myStack.push(9);
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        myStack.push(13);
        myStack.push(14);
        myStack.push(15);
        while( !myStack.isEmpty() ) {
            System.out.print("size: " + myStack.size + " ");
            System.out.println(myStack.pop());
        }
    }
}
