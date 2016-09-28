package com.twosum;

import java.util.HashMap;

/**
 * 使用hashmap解决
 * @author Yo
 *
 */
public class TwoSum2 {
	
	public static void main(String[] args) {
		for(int r : twoSum(new int[]{2, 5, 5, 7, 9, -1, 12}, 11))
			System.out.println(r);
	}
	
    public static int[] twoSum(int[] numbers, int target) {
       int[] a = new int[2];
       HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
       for(int i=0; i<numbers.length; i++) {
    	   Integer n = nums.get(numbers[i]);
    	   if(n == null) {
    		   nums.put(numbers[i], i);
    	   }
    	   n = nums.get(target - numbers[i]);
    	   if(n!=null && n<i) {
    		   a[0] = n + 1;
    		   a[1] = i + 1;
    		   return a;
    	   }
       }
       return a;
    }
}
