package com.yo.arrangecombine.part1;

/**站队问题练习题
   n个人站队，他们的编号依次从1到n，要求编号为a的人必须在编号为b的人的左边，但不要求一定相邻，请问共有多少种排法？第二问如果要求a必须在b的左边，并且一定要相邻，请问一共有多少种排法？
   给定人数n及两个人的编号a和b，请返回一个两个元素的数组，其中两个元素依次为两个问题的答案。保证人数小于等于10。
   测试样例：
       7,1,2
   返回：[2520,720]
 * Created by Yo on 2017/3/11.
 */
public class StandInline {
    public static void main(String[] args) {

    }
    public static int[] getWays(int n, int a, int b) {
        if( n <= 1 ) {
            return null;
        }
        //不相邻的排法（n的阶乘的一半，一半在左边，一半在右边）
        int a1 = 1;
        for(int i=1; i<=n; i++) {
            a1 *= i;
        }
        //相邻的排法（n-1的阶乘
        int a2 = 1;
        for(int i=1; i<=n-1; i++) {
            a2 *= i;
        }
        return new int[]{a1/2, a2};
    }
}
