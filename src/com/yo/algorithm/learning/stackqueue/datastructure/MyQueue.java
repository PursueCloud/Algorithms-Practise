package com.yo.algorithm.learning.stackqueue.datastructure;

/**
 * 队列
 * Created by Yo on 2017/3/4.
 */
public class MyQueue {
    int[] data;
    int capacity = 10;
    int currIndex;
    int size;
    boolean isFirst = true;

    private void initData() {
        data = new int[capacity];
    }

    public MyQueue() {
        initData();
    }

    public MyQueue(int capacity) {
        this.capacity = capacity;
        initData();
    }

    public void addElem(int value) {
        data[currIndex++] = value;
        size++;
    }

    public void add(int value) throws Exception {
        if( currIndex == data.length && !isFirst ) {
            int[] newData = new int[data.length + 10];
            for(int i=0; i<data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        addElem(value);
        isFirst = false;
    }

    public int poll() throws Exception {
        if( currIndex == 0 ) {
            throw new Exception("队列已空，无法取出数据！");
        } else {
            size--;
            int res = data[0];
            for(int i=0; i<currIndex-1; i++) {
                data[i] = data[i+1];
            }
            currIndex--;
            return res;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if( currIndex == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);
        myQueue.add(9);
        myQueue.add(10);
        myQueue.add(11);
        myQueue.add(12);
        myQueue.add(13);
        myQueue.add(14);
        myQueue.add(15);
        while( !myQueue.isEmpty() ) {
            System.out.print("size: " + myQueue.size + " ");
            System.out.println(myQueue.poll());
        }
    }
}
