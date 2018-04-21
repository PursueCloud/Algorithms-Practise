package com.yo.algorithm.stackqueue.part2;

import java.util.*;

/**
 * 双栈排序练习题：
   请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
   给定一个int[] numbers(C++中为vector<int>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
   测试样例：
       [1,2,3,4,5]
   返回：[5,4,3,2,1]
 * Created by Yo on 2017/3/4.
 */
public class StackSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(twoStacksSortUseArray(arr).toArray()));
    }

    /**
     * 利用栈逆序的思想对数组进行逆序
     * @param numbers
     * @return
     */
    public static ArrayList<Integer> twoStacksSortUseArray(int[] numbers) {
        if( numbers==null || numbers.length<1 ) {
            return null;
        }
        int[] help = new int[numbers.length];
        int n = numbers.length - 1;
        int m = -1;
        while( n >= 0 ) {
            int key = numbers[n--];
            if( m == -1 ) {
                help[++m] = key;
            } else {
                if( help[m] > key ) {
                    help[++m] = key;
                } else {
                    int k = m;
                    while( k>=0 && help[k]<=key ) {
                        help[k+1] = help[k];
                        k--;
                    }
                    help[k+1] = key;
                    m++;
                }
            }
        }
        ArrayList<Integer> resList = new ArrayList<Integer>();
        for(int a : help) {
            resList.add(a);
        }
        return resList;
    }

    /**
     * 栈逆序
     * @param numbers
     * @return
     */
    public static ArrayList<Integer> twoStacksSortUseStack(int[] numbers) {
        if( numbers==null || numbers.length<1 ) {
            return null;
        }
        //根据数组构造栈（注意要逆序
        Stack<Integer> stack1 = new Stack<Integer>();
        for(int i=numbers.length-1; i>=0; i--) {
            stack1.push(numbers[i]);
        }
        Stack<Integer> stack2 = new Stack<Integer>();
        while( !stack1.isEmpty() ) {//循环至stack1为空
            int top1 = stack1.pop();//弹出stack1栈顶元素top
            if( stack2.isEmpty() ) {//如果stack2为空，则直接将stack1的栈顶元素top1添加到stack2
                stack2.push(top1);
            } else {//如果stack2不为空
                int top2 = stack2.peek();//获取stack2的栈顶元素top2
                if( top2 > top1 ) {//如果stack2的栈顶元素top2比stack1的栈顶元素top1大，则将stack1的栈顶元素top1
                    stack2.push(top1);
                } else {//如果stack2的栈顶元素top2比stack1的栈顶元素top1小，则将stack2中所有比stack1栈顶元素top1小的元素添加到stack1中
                    int tempTop = stack2.peek();
                    while( !stack2.isEmpty() && tempTop<=top1) {
                        stack1.push(stack2.pop());
                    }
                    stack2.push(top1);//将stack1的栈顶元素添加到stack2中
                }
            }
        }
        ArrayList<Integer> resList = new ArrayList<Integer>();
        for(int i=0; i<stack2.size(); i++) {
            resList.add(stack2.get(i));
        }
        return resList;
    }
}
