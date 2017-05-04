package com.yo.bitcalc;

/**寻找奇数
 * Created by Yo on 2017/3/11.
 */
public class OddAppearance {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 3, 1};
        System.out.println(findOdd(arr, arr.length));
    }

    /**寻找奇数出现练习题：
       有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
       给定整形数组A及它的大小n，请返回题目所求数字。
       测试样例：
           [1,2,3,2,1],5
       返回：3
     * @param A
     * @param n
     * @return
     */
    public static int findOdd(int[] A, int n) {
        if( A==null || n<=2 ) {
            return -1;
        }
        int res = 0;
        for(int a : A) {
            res ^= a;
        }
        return res;
    }

    /**寻找奇数出现II练习题：
       给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
       给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
       测试样例：
           [1,2,4,4,2,1,3,5],8
       返回：[3,5]
     * @param arr
     * @param n
     * @return
     */
    public static int[] findOdds(int[] arr, int n) {
        if( arr==null || n<2 ) {
            return null;
        }
        int eO=0, eOhasOne=0;
        for(int curNum : arr) {
            eO ^= curNum;
        }
        int rightOne = eO & (~eO + 1);
        for(int cur : arr) {
            if( (cur&rightOne) != 0 ) {
                eOhasOne ^= cur;
            }
        }
        int small = Math.min(eOhasOne, eO^eOhasOne);
        int big = Math.max(eOhasOne, eO^eOhasOne);
        return new int[]{small, big};
    }

    public static int[] findOddsTest(int[] arr, int n) {
        if( arr==null || n<=2 ) {
            return null;
        }
        int e0=0, e0hasOne=0;
        for(int a : arr) {
            e0 ^= a;
        }
        int rightOne = e0 & (~e0 + 1);
        for(int cur : arr) {
            if( (cur&rightOne) != 0 ) {
                e0hasOne ^= cur;
            }
        }
        int small = Math.min(e0hasOne, e0^e0hasOne);
        int big = Math.max(e0hasOne, e0^e0hasOne);
        return new int[]{small, big};
    }
}
