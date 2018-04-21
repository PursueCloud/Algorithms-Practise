package com.yo.algorithm.string.part2;

/**
 * 字符串移位练习题
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
   给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
   测试样例：
       "ABCDE",5,3
       返回："DEABC"
   解题思路：
       先对0-len的子串进行逆序调整，然后对len到n-1的子串做逆序调整，最后对整个字符串做逆序调整接口
 * Created by Yo on 2017/3/4.
 */
public class Translation {
    public static void main(String[] args) {
        String str = "ABCDE";

        System.out.println(stringTranslation(str, str.length(), 3));
    }

    public static String stringTranslation(String A, int n, int len) {
        if( A==null || "".equals(A) || n==len ) {
            return A;
        }
        String s1 = reverseString(A.substring(0, len));
        String s2 = reverseString(A.substring(len, n));
        StringBuilder resbuilder = new StringBuilder().append(s1).append(s2);
        return reverseString(resbuilder.toString());
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
