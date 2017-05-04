package com.yo.iq;

/**游戏练习题:
   A与B做游戏。 在一个n*m的矩阵中的出发点是（1，m），终点是（n,1），规则是只能向左移动一格，向下一格或向左下移动一格，先走到终点的为winner。 A先走。
   给定两个整数n和m，请返回最后的获胜者的名字(A或B)。
   测试样例：
       5 3
   返回：B
 * Created by Yo on 2017/3/12.
 */
public class Game {
    public char getWinner(int n, int m) {
        if( m%2!=0 && n%2!=0 )
            return 'B';
        else
            return 'A';
    }
}
