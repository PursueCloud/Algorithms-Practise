package com.yo.arrangecombine.part2;

/**错装信封练习题：
   有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来的信封，问有多少种装法?
   给定一个整数n，请返回装发个数，为了防止溢出，请返回结果Mod 1000000007的值。保证n的大小小于等于300。
   测试样例：
       2
   返回：1
 * Created by Yo on 2017/3/11.
 */
public class CombineByMistake {
    public static void main(String[] args) {

    }

    public static int countWays(int n) {
        if( n == 1 ) {
            return 0;
        } else if( n == 2 ) {
            return 1;
        } else {
            int modNum = 1000000007;
            long pre=0, last=1;
            for(int i=3; i<=n; i++) {
                long tmp = ((i-1)*(pre+last)) % modNum;
                pre = last;
                last = tmp;
            }
            return (int)last;
        }
    }
}
