package com.yo.stackqueue.part2;

import java.util.Arrays;
import java.util.Stack;

/**栈的反转练习题:
   实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
   给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
   测试样例：
       [4,3,2,1],4
   返回：[1,2,3,4]
 * Created by Yo on 2017/3/4.
 */
public class StackReverse {
    public static void main(String[] args) {
        int[] arr = {4 ,3, 2, 1};
        System.out.println(Arrays.toString(reverseStack2(arr, arr.length)));
    }

    public static int[] reverseStack(int[] A, int n) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int a : A) {
            stack.push(a);
        }
        reverse(stack);
        for(int i=n-1; i>=0; i--) {
            if( !stack.isEmpty() ) {
                A[i] = stack.pop();
            }
        }
        return A;
    }

    public static int getBottom(Stack<Integer> stack) {
        int result = stack.pop();
        if( stack.isEmpty() ) {
            return result;
        } else {
            int bottom = getBottom(stack);
            stack.push(result);
            return bottom;
        }
    }
    public static void reverse(Stack<Integer> stack) {
        if( stack.isEmpty() ) {
            return;
        }
        int i = getBottom(stack);
        reverse(stack);
        stack.push(i);
    }

    //方法二：
    public static int[] reverseStack2(int[] A, int n) {
        // write code here
        if(A==null||n<2){
            return A;
        }
        int i=A[0];
        for(int j=1;j<n;j++){
            A[j-1]=A[j];
        }
        reverseStack(A,n-1);
        A[n-1]=i;
        return A;
    }
}
