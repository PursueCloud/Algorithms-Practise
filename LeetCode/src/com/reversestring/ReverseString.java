package com.reversestring;
/**
 * 
 * @author Yi
 * LeetCode第344题 Reverse String，将一个字符串反转,如“hello”，返回结果为“olleh”
 *
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverseString("hello sdf"));
	}

	public static String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}
