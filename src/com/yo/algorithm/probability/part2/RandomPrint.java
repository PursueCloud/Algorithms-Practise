package com.yo.algorithm.probability.part2;

import java.util.Random;

/**随机数组打印练习题:
   给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率
   随机打印arr中的M个数。
 * Created by Yo on 2017/3/11.
 */
public class RandomPrint {
    private static Random rand = new Random(123456);

    public int[] print(int[] arr, int N, int M) {
        int[] result = new int[M];
        int index = N-1;
        for(int i=0; i<M; i++){
            int j = rand.nextInt(index);
            result[i] = arr[j];
            //把打印的数和最后的数交换位置
            int temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;
            index--;
        }
        return result;
    }

    public int[] printTest(int[] arr, int N, int M) {
        int[] res = new int[M];
        int index = N - 1;
        for(int i=0; i<M; i++) {
            int j = rand.nextInt(index);
            res[i] = arr[j];

            int temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;
            index--;
        }
        return res;
    }
}
