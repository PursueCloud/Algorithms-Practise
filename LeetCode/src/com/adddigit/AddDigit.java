package com.adddigit;

public class AddDigit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(addDigits2(11));
	}
	/**
	 * 38: 3+8=11, 1+1=2,结果为2
	 * 99: 9+9=18, 1+8=9
	 * 23: 2+3=5;
	 * ①递归解法（O（n^2)时间复杂度），不可取
	 * @param num
	 * @return
	 */
	public static int addDigits(int num) {
		if(num < 10)
			return num;
		int tenNum = num/10;
		int perNum = num - tenNum*10;
		return addDigits(tenNum + perNum);
    }
	/**
	 * 存在的规律
	 * @param num
	 * @return
	 */
	public static int addDigits2(int num) {
		if(num < 10)
			return num;
		return (num-1)%9 + 1;
    }
}
