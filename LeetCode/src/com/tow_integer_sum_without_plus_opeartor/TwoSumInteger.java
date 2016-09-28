package com.tow_integer_sum_without_plus_opeartor;

/**
 * 不使用运算符+ 或 - 算出两个数的和
 * @author Yo
 *
 */
public class TwoSumInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sum(1034, 2000));
	}
	/**
	 * 递归移位直到b为0
	 * @param a
	 * @param b
	 * @return
	 */
	public static int sum(int a, int b) {
		if(0 == b)
			return a;
		int cxoa = a ^ b;
		int cand = a & b;
		return sum(cxoa, cand<<1);
	}
}
