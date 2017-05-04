package com.yo.dynamicplan.part2;

/**最优编辑练习题：
   对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
   给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
   测试样例：
       "abc",3,"adc",3,5,3,100
   返回：8
 * Created by Yo on 2017/3/12.
 */
public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        if( (A==null && B==null) || (m==0 && n==0) ) {
            return 0;
        }
        int[] dp = new int[m+1];
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for(int i=0; i<=m; i++) {
            dp[i] = i*c0;
        }
        for(int i=1;i<=n;i++) {
            int pre = dp[0];
            dp[0] = c1*i;
            for(int j=1; j<=m; j++) {
                int cur = 0;
                if( a[i-1] == b[j-1] ) {
                    cur = pre;
                } else {
                    cur = pre + c2;
                }
                pre = dp[j];
                dp[j] = Math.min(dp[j]+c1, Math.min(cur, dp[j-1]+c0));
            }
        }
        return dp[m];
    }

    public int findMinCostTest(String A, int n, String B, int m, int c0, int c1, int c2) {
        if( (A==null && B==null) || (n==0 && m==0) ) {
            return 0;
        }
        int[] dp = new int[m+1];
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for(int i=0; i<=m; i++) {
            dp[i] = c0*i;
        }
        for(int i=1; i<=n; i++) {
            int pre = dp[0];
            dp[0] = c1*i;
            for(int j=1; j<=m; j++) {
                int cur = 0;
                if( a[i-1] == b[j-1] ) {
                    cur = pre;
                } else {
                    cur = pre + c2;
                }
                pre = dp[j];
                dp[j] = Math.min(dp[j]+c1, Math.min(cur, dp[j-1]+c2));
            }
        }
        return dp[m];
    }
}
