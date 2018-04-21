package com.yo.algorithm.practise.leetcode.reversestring;
/**
 * 
 * @author Yi
 * LeetCode��344�� Reverse String����һ���ַ�����ת,�硰hello�������ؽ��Ϊ��olleh��
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
