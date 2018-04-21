package com.yo.algorithm.iq;

import java.util.Arrays;

/**数组清空练习题：
   现在有一个整数数组，其元素值均为1-n范围内的某个整数，现在你和你的朋友在玩一个游戏，游戏的目的是把数组清空，
   你们轮流操作，你是先手，每次操作你可以删除数组中值为某个数的元素任意多个(当然数组中值为这个数的元素个数应
   大于等于你删除的个数,且你至少要删除一个数)。最先把数组清空的人获得胜利。假设你们都采取最优策略，请你计算你
   能否获得胜利。给定一个整数数组A和元素个数n。请返回一个整数，1代表你能获胜，0代表你不能获胜。
   测试样例：
       [1,1,1]
   返回：1
 * Created by Yo on 2017/3/12.
 */
public class Clear {
    public int getWinner(int[] arr, int n) {
        int res = 0;
        Arrays.sort(arr);
        for(int i=0, j; i<n; i++) {
            j = i;
            while( j<n && arr[i]==arr[j] ) {
                j++;
            }
            res ^= j - i;
        }
        return res==0 ? 0 : 1;
    }
}
