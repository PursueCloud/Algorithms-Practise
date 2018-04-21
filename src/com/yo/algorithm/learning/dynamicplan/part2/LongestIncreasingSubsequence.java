package com.yo.algorithm.learning.dynamicplan.part2;

/**LIS练习题:
   这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
   给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
   测试样例：
       [1,4,2,5,3],5
   返回：3
 * Created by Yo on 2017/3/12.
 */
public class LongestIncreasingSubsequence {
    public int getLIS(int[] arr, int n) {
        if( arr==null ) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int temp = 0;
        for(int i=1; i<n; i++) {
            temp = 0;
            for(int j=i-1; j>=0; j--) {
                if( arr[i]>arr[j] && dp[j]>temp ) {
                    temp = dp[j];
                }
                dp[i] = temp + 1;
            }
        }
        temp = 0;
        for(int num : dp) {
            temp = Math.max(num, temp);
        }
        return temp;
    }

}
