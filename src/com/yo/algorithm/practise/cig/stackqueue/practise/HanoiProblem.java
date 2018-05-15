package com.yo.algorithm.practise.cig.stackqueue.practise;


import java.util.Stack;

/**
 * 思路：
 *      递归：
 *          终结条件：
 *                  1、当只剩下1层塔时，如果从左或右移到中，则打印“Move 1 from left/right to mid”；
 *                  否则打印“Move 1 from left/right to mid”和“Move 1 from mid to right/right”
 *                  2、当升序N层塔时，如果从左或右移到中，则分为以下3步：
 *                        ①将N-1层塔从左移到右或从右移到左，这个步骤为递归实现
 *                        ②将第N层塔从左移到中或从右移到中,移动步数为1
 *                        ③将N-1层塔从右移到中或从左移到中，这个步骤为递归调用
 *                  否则，分为以下3步：
 *                        ①将N-1层塔从左移到右或从右移到左，这个步骤为递归调用
 *                        ②将第N层塔从左移到中或从右移到中，移动的步数为1
 *                        ③将N-1层塔从右移到左或从左移到右，这个步骤为递归调用
 *                        ④将第N层塔从中移到右或从中移到左，移动的步数为1
 *                        ⑤将N-1层塔从左移到右或从右移到左，这个步骤为递归调用
 *
 *      非递归：
 *             三个原则：
 *                  1、不可逆原则：
 *                      ①如果上一步是M-》L，则下一步不可能是L-》M
 *                  2、小压大原则：
 *                      ①被移动元素一定比目标所在的元素小
 *                      ②如果上一个是M-》L，那么下一步不可能是M-》L
 * 解法：
 *      如思路所述
 */
public class HanoiProblem {

    public static int hanoiProblemRecursive(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        System.out.println("solve hanoi problem recursive");
        return process(num, left, mid, right, left, right);
    }
    private static int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (left.equals(mid) || right.equals(mid)) {
                System.out.println("Move 1 from " + left + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + right);
                return 2;
            }
        } else {
            if (left.equals(mid) || right.equals(mid)) {
                String another = (from.equals(left) || to.equals(left)) ? right : left;
                int part1 = process(num-1, left, mid, right, from, another);
                int part2 = 1;
                System.out.println("Move " + num + " from " + from + " to " + to);
                int part3 = process(num-1, left, mid, right, another, to);
                return part1 + part2 + part3;
            } else {
                int part1 = process(num-1, left, mid, right, from, to);
                int part2 = 1;
                System.out.println("Move " + num + " from " + from + " to " + mid);
                int part3 = process(num-1, left, mid, right, to, from);
                int part4 = 1;
                System.out.println("Move " + num + " from " + mid + " to " + to);
                int part5 =  process(num-1, left, mid, right, from, to);
                return part1 + part2 + part3 + part4 + part5;
            }
        }
    }

    public static int hanoiProblemUnRecursive(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        System.out.println("solve hanoi problem unRecursive");
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i=num; i>0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.NO};
        int step = 0;
        while (rS.size() != num+1) {
            step += moveFromToInStack(record, Action.MTOL, Action.LTOM, lS, mS, left, mid);
            step += moveFromToInStack(record, Action.LTOM, Action.MTOL, mS, lS, mid, left);
            step += moveFromToInStack(record, Action.RTOM, Action.MTOR, mS, rS, mid, right);
            step += moveFromToInStack(record, Action.MTOR, Action.RTOM, rS, mS, right, mid);
        }
        return step;
    }
    private enum Action {
        NO,
        LTOM,
        MTOL,
        MTOR,
        RTOM
    }

    /**
     * 将一个塔从一个栈移动到另一个栈
     * @param record
     * @param preAct
     * @param nowAct
     * @param fromStack
     * @param toStack
     * @param from
     * @param to
     * @return
     */
    private static int moveFromToInStack(Action[] record, Action preAct, Action nowAct, Stack<Integer> fromStack,
                                         Stack<Integer> toStack, String from, String to) {
        //当前动作不等于前一个动作（相邻不可逆原则
        //移动的元素一定比目标位置当前元素小（小压大原则
        if (record[0] != preAct && fromStack.peek()<toStack.peek()) {
            toStack.push(fromStack.pop());
            System.out.println("Move " + toStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }
}
