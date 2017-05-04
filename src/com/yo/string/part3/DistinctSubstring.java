package com.yo.string.part3;

import java.util.Arrays;

/**最长无重复字符子串练习题:
   对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
   给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
   测试样例：
       "aabcb",5
   返回：3
   解题思路：使用hash表记录每个字母第一次出现的位置，使用整型pre记录其上一次出现的位置
 * Created by Yo on 2017/3/4.
 */
public class DistinctSubstring {
    public static void main(String[] args) {
        String str = "aabcbefghij";
//        System.out.println(longestSubstring(str, str.length()));
        String str2 = "aabcb";
        System.out.println(longestSubstringCont(str2, str2.length()));
    }

    /**
     * 获取字符串最长无重复子串的长度
     * @param A
     * @param n
     * @return
     */
    public static int longestSubstring(String A, int n) {
        if( A==null || n<1 ) {
            return 0;
        }
        char[] chas = A.toCharArray();
        int[] map = new int[256];
        //初始化hash表
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            pre = Math.max(pre, map[chas[i]]);//map[chas[i]]：当前字符上一次出现的位置，pre：0-chas[i-1]字符中所有字符的出现位置的最大值
            cur = i - pre;//长度
            len = Math.max(len, cur);//求长度最大值
            map[chas[i]] = i;
        }
        return len;
    }
    /**
     * 获取字符串最长无重复子串的长度
     * @param A
     * @param n
     * @return
     */
    public static int longestSubstringlen(String A, int n) {
        if( A==null || n<1 ) {
            return 0;
        }
        char[] chas = A.toCharArray();
        int[] map = new int[256];
        for(int i=0; i<256 ; i++) {
            map[i] = -1;
        }
        int pre=-1, len=0, cur=0;
        for(int i=0; i<n; i++) {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }

    /**
     * 获取字符串中最长无重复子串的开始和结束下标,返回长度为2的数组，0位置为开始下标，1位置为结束下标
     * @param A
     * @param n
     * @return
     */
    public static int[] longestSubstringIndexs(String A, int n) {
        if( A==null || n<1 ) {
            return null;
        }
        char[] chas = A.toCharArray();
        int[] map = new int[256];
        for(int i=0; i<256 ; i++) {
            map[i] = -1;
        }
        int pre=-1, len=0, cur=0;
        int start=0, end=0;
        for(int i=0; i<n; i++) {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            if( len == cur ) {//每次更新最长无重复子串的长度时，获取最长无重复子串的开始下标和结束下标
                start = pre;
                end = i;
            }
            map[chas[i]] = i;
        }
        return new int[]{start, end};
    }

    /**
     * 获取字符串最长无重复子串
     * @param A
     * @param n
     * @return
     */
    public static String longestSubstringCont(String A, int n) {
        int[] resArr = longestSubstringIndexs(A, n);
        int start = resArr[0];
        int end = resArr[1];
        return A.substring(start+1, end+1);
    }
}
