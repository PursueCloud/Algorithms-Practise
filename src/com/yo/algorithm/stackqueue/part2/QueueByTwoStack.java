package com.yo.algorithm.stackqueue.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用两个栈模拟队列：
 * 解题思路：
 *     使用一个栈push数据，另一个栈pop数据,每一次取数据之前往pop栈压入数据
 *     往pop栈压入数据必须满足一下两点：
 *          ①push栈中数据必须一次性全部压入到pop栈中
 *          ②pop栈中有数据时不能讲push栈中数据压入到pop栈，否则数据会错乱
 * Created by Yo on 2017/3/4.
 */
public class QueueByTwoStack {
    Stack<Integer> stackPush = new Stack<Integer>();
    Stack<Integer> stackPop = new Stack<Integer>();

    public void transferDataFromPushToPop() {
        while( !stackPush.isEmpty() ) {
            stackPop.push(stackPush.pop());
        }
    }

    public void add(int value) {
        stackPush.push(value);
    }

    public int poll() {
        if( stackPop.isEmpty() ) {
            transferDataFromPushToPop();
        }
        return stackPop.pop();
    }

    public boolean isEmpty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

    public int size() {
        return stackPush.size() + stackPop.size();
    }


    /** 双栈队列练习题:
     * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
       给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
       测试样例：
           [1,2,3,0,4,0],6
       返回：[1,2]
     * @param ope
     * @param n
     * @return
     */
    public int[] twoStack(int[] ope, int n) {
        QueueByTwoStack queue = new QueueByTwoStack();
        List<Integer> queueData = new ArrayList<Integer>();
        for(int a : ope) {
            if( a > 0 ) {
                queue.add(a);
            } else {
                queueData.add(queue.poll());
            }
        }
        int[] resData = new int[queueData.size()];
        for(int i=0; i<resData.length; i++) {
            resData[i] = queueData.get(i);
        }
        return resData;
    }

    public static void main(String[] args) throws Exception {
        QueueByTwoStack myQueue = new QueueByTwoStack();
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
//            System.out.print("size: " + myQueue.size + " ");
            System.out.println(myQueue.poll());
        }
    }
}
