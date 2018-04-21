package com.yo.algorithm.string.part1;

import java.util.HashMap;
import java.util.Map;

/**词语变形练习题:
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，
 * 检查两给定串是否互为变形词。给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
   测试样例：
    "abc",3,"bca",3
    返回：true

   解题思路：
       使用两个hash表对每个字符串进行词频统计，最后再对比着两个hash表中每一项（key）对应的值（value）是否相等，如果是，则返回true，否则返回false
 * Created by Yo on 2017/3/4.
 */
public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        if( A==null || lena<1 || B==null || lenb<1 ) {
            return false;
        }
        Map<String, Integer> aMap = new HashMap<String, Integer>();
        Map<String, Integer> bMap = new HashMap<String, Integer>();
        for(char aChar : A.toCharArray()) {
            if( !aMap.containsKey(aChar) ) {
                aMap.put(aChar + "", 1);
            } else {
                int cnt = aMap.get(aChar + "");
                cnt++;
                aMap.put(aChar + "", cnt);
            }
        }
        for(char bChar : B.toCharArray()) {
            if( !bMap.containsKey(bChar) ) {
                bMap.put(bChar + "", 1);
            } else {
                int cnt = bMap.get(bChar + "");
                cnt++;
                bMap.put(bChar + "", cnt);
            }
        }
        if( aMap.size() != bMap.size() ) {
            return false;
        } else {
            for(String key : aMap.keySet() ) {
                int aCnt = aMap.get(key);
                int bCnt = 0;
                if( bMap.containsKey(key) ) {
                    bCnt = bMap.get(key);
                }
                if( aCnt != bCnt ) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean chkTransformTest(String A, int lenA, String B, int lenB) {
        if( A==null || B==null || lenA!=lenB ) {
            return false;
        }
        char[] chasA = A.toCharArray();
        char[] chasB = B.toCharArray();
        int[] map = new int[256];
        for(char c : chasA) {
            map[c]++;
        }
        for(char c : chasB) {
            if( map[c]-- == 0 ) {
                return false;
            }
        }
        return true;
    }
}
