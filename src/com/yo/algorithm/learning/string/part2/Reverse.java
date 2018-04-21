package com.yo.algorithm.learning.string.part2;

/**句子的逆序练习题：
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
   给定一个原字符串A和他的长度，请返回逆序后的字符串。
   测试样例：
       "dog loves pig",13
       返回："pig loves dog"
   解题思路：
        ①先实现一个队整个字符串进行逆序调整的方法，②然后对0到n-1之间的所有字符串进行逆序调整，即0和n-1逆序、1和n-2逆序，一直调整至n/2+1位置，③然后再对每一个单词进行逆序调整即可
 * Created by Yo on 2017/3/4.
 */
public class Reverse {
    public static void main(String[] args) {
        String str = "dog loves pig";

        System.out.println(reverseSentence(str, str.length()));
    }
    public static String reverseSentence(String A, int n) {
        if( A==null || "".equals(A) || n<2 ) {
            return "";
        }
        String rvsStr = reverseString(A);
        String[] strArr = rvsStr.split(" ");
        StringBuilder resBuilder = new StringBuilder();
        for(int i=0; i<strArr.length; i++) {
            if( i == 0 ) {
                resBuilder.append(reverseString(strArr[i]));
            } else {
                resBuilder.append(" ").append(reverseString(strArr[i]));
            }
        }
        return resBuilder.toString();
    }

    public static String reverseString(String str) {
        if( str==null || "".equals(str) ) {
            return "";
        }
        char[] chas = str.toCharArray();
        int start = 0;
        int end = chas.length - 1;
        while( start <= end ) {
            char tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
        return String.valueOf(chas);
    }

}
