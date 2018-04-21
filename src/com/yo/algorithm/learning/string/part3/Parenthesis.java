package com.yo.algorithm.learning.string.part3;

/**合法括号序列判断练习题：
   对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
   给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
   测试样例：
       "(()())",6
   返回：true
   测试样例：
       "()a()()",7
   返回：false
   测试样例：
       "()(()()",7
   返回：false
   解题思路：
       使用一个int类型数去计算括号出现，当左括号出现时+1，右括号出现时-1，最后，如果该数值
       为0，则表示该字符串为一个合法的括号串，如果大于0，表示左括号比右括号多；否则右括号
       比左括号多
 * Created by Yo on 2017/3/4.
 */
public class Parenthesis {
    public static void main(String[] args) {
        String str1 = "(()())";
        String str2 = "()a()()";
        String str3 = "()(()()";
        String str4 = ")))))())(()))(()()((())((((((()()))(((()())))()()((())()))))()(()()(())(()))))))))((())(())((())(())(())()()(()()(()(()())()()))()(((()))(((()))()(()(()((((()()))))(()()))))()((((()((((())((())))())((()())))((())()(())()()(()()()d";
        System.out.println(chkParenthesis(str4, str4.length()));
    }

    public static boolean chkParenthesis(String A, int n) {
        if( A==null || "".equals(A) || n%2==1 ) {
            return false;
        }
        char[] chas = A.toCharArray();
        int ptsCnt = 0;
        for(char c : chas) {
            if( c == '(' ) {
                if( ptsCnt < 0 ) {//ptsCnt小于0，表示右括号先出现
                    return false;
                }
                ptsCnt++;
            } else if( c == ')' ) {
                ptsCnt--;
            } else {//非括号字符串出现，则直接返回false
                return false;
            }
        }
        if( ptsCnt == 0 ) {
            return true;
        } else {
            return false;
        }
    }
}
