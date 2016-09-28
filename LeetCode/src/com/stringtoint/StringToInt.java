package com.stringtoint;

import java.math.BigInteger;

public class StringToInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(myAtoi("++10"));
	}
	
	public static int myAtoi(String str) {
		if(!str.trim().matches("[0-9]+"))
			return 0;
		BigInteger bi = new BigInteger(str.trim());
		if(bi.compareTo(new BigInteger("2147483647")) >= 0)
			return (int)2147483647L;
        return Integer.parseInt(str.trim());
    }

}
