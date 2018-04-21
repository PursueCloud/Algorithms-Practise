package com.yo.algorithm.learning.dynamicplan.part1;

/**找零钱练习题:
   有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
   给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
   测试样例：
       [1,2,4],3,3
   返回：2
 * Created by Yo on 2017/3/12.
 */
public class ExchangeCoins {
    /**
     * 动态规划
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public int countWays(int[] penny, int n, int aim) {
        int[] dp = new int[aim+1];
        for(int i=0; i<=aim; i++) {
            if( i%penny[0] == 0 ) {
                dp[i] = 1;
            }
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<=aim; j++) {
                if( j >= penny[i] ) {
                    dp[j] += dp[j-penny[i]];
                }
            }
        }

        return dp[aim];
    }

    /**
     * 暴力搜索方法，时间复杂度很高
     * arr={5,10,25,1}，aim=1000
     * 注：如果已经使用0张5元和1张10元的情况下，后续将求：p1（arr，2,990）（2：表示arr剩下的钱为arr[2,3]，即[25,1]
     * 990：表示要找的剩余钱数。当已经使用2张5元和0张10元的情况下，后续还是要求p1（arr，2,990）
     */
    public int coins1(int[] arr, int aim) {
        if( arr==null || arr.length==0 || aim<0 ) {
            return 0;
        }
        return process1(arr, 0, aim);
    }
    public int process1(int[] arr, int index, int aim) {
        int res = 0;
        if( index == arr.length ) {
            res = aim==0 ? 1 : 0;
        } else {
            for(int i=0; arr[index]*i<=aim; i++) {
                res += process1(arr, index+1, aim-arr[index]*i);
            }
        }
        return res;
    }
    /**
     * 记忆搜索方法
     * arr={5, 10, 25, 1}, aim=1000
     */
    public int coins2(int[] arr, int aim) {
        if( arr==null || arr.length==0 || aim<0 ) {
            return 0;
        }
        int[][] map = new int[arr.length+1][aim+1];
        return process2(arr, 0, aim, map);
    }
    public int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if( index == arr.length ) {
            res = aim==0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for(int i=0; arr[index]*i<=aim; i++) {
                mapValue = map[index+1][aim-arr[index]*i];
                if( mapValue != 0 ) {
                    res += mapValue==-1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index+1, aim-arr[index]*i, map);
                }
            }
        }
        map[index][aim] = res==0 ? -1 : res;
        return res;
    }
}
