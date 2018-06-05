package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.review_practise;

import java.util.Stack;

/**
 * 思路：
 *      使用辅助栈help对栈stack中数据进行排序。当help为空或stack中栈顶元素比help栈顶元素小时，将stack栈顶元素压入help中。
 *      否则，将help中所有元素压回stack中，然后将刚刚弹出的stack栈顶元素压入help中。重复这一步骤直到栈stack为空。最后，将help中所有元素压入stack中，即实现排序
 * 解法：
 *      如思路所述
 *
 */
public class StackSortByAnotherStack {

    public static <T> void sort(Stack<T> stack) {
        Stack<T> help = new Stack<>();
        while (!stack.empty()) {
            //此处stack栈顶元素与help栈顶元素的比较方式取决于排序方式是升序还是降序，如果是从栈顶到栈顶降序，则<=0，否则>=0
            T currElem = stack.pop();
            if (help.empty() || ((Comparable)currElem).compareTo(help.peek())<=0) {
                help.push(currElem);
            } else {
                while (!help.empty()) {
                    stack.push(help.pop());
                }
                help.push(currElem);
            }
        }
        while (!help.empty()) {
            stack.push(help.pop());
        }
    }
}
