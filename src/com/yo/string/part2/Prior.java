package com.yo.string.part2;

import java.util.Arrays;
import java.util.Comparator;

/**拼接最小字典序练习题：
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
   给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
   测试样例：
      ["abc","de"],2
   返回"abcde"
   解题思路：
       判断A+B的字典序是否>B+A的字典序，如果是，返回A+B，否则返回B+A
 * Created by Yo on 2017/3/4.
 */
public class Prior {
    public static void main(String[] args) {
        String[] strArr = {"abc","de"};

        System.out.println(findSmallest(strArr, strArr.length));
    }
    public static String findSmallest(String[] strs, int n) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String m1 = s1 + s2;
                String m2 = s2 + s1;
                return m1.compareTo(m2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for(String s : strs) {
            builder.append(s);
        }
        return builder.toString();
    }

}
