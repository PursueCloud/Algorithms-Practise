package com.yo.algorithm.practise.cig.stackqueue.solvehanoiproblemwithstack6.impl;

import javafx.geometry.Point3D;

/**
 * 用栈来求解汉诺塔问题
 * 哈诺塔问题描述：
 *     游戏是在一块铜板装置上，有三根杆(编号A、B、C)，在A杆自下而上、由大到小（从上往下为小到大）按顺序放置64个金盘(如下图)。
 *     游戏的目标：把A杆上的金盘全部移到C杆上，并仍保持原有顺序叠好。操作规则：每次只能移动一个盘子，并且在移动过程中三根杆上都
 *     始终保持大盘在下，小盘在上，操作过程中盘子可以置于A、B、C任一杆上。
 * 限制：不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。求当塔有N层的时候，打印最右移动过程和
 *     最右移动总步数
 */
public class SolveHanoiProblemWithStack {

    /**
     * 求解汉诺塔问题
     * @param num 层数，即金盘的个数
     */
    public static int solveHanoiProblemRecursive(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }
    private static int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equalsIgnoreCase(mid) || to.equalsIgnoreCase(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equalsIgnoreCase(mid) || to.equalsIgnoreCase(mid)) {
            String another = (from.equalsIgnoreCase(left) || to.equalsIgnoreCase(left)) ? right : left;
            int part1 = process(num -1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num -1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num -1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num -1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }
}
