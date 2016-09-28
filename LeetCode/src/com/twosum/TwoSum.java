package com.twosum;

import java.util.HashMap;

public class TwoSum {

	/**
	 * @LeetCode第1题 TwoSum,给定一个数组和int类型数target，
	 * 求数组中值相加等target的两个数在数组中的位置，返回一个保存这两个下标的数组
	 * 如：nums={2， 7， 11， 15}，target=9，则返回的数组为{0， 1}
	 */
	public static void main(String[] args) {
		int[] nums = {0, 4, 3, 0};
		for(int a : twoSum2(nums, 7)) {
			System.out.println(a);
		}
			
	}
	/**
	 * O(n^2)的时间复杂度 
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] a = new int[2];
        for(int i=0; i<nums.length-1; i++) {
        	for(int j=i+1; j<nums.length; j++) {
	        	if((nums[i]+nums[j]) == target) {
	        		a[0] = i;
	        		a[1] = j;
	        		break;
	        	}
        	}
        }
		
		return a;
    }
	/**
	 * O(n)的时间复杂度 
	 */
	public static int[] twoSum2(int[] numbers, int target) {
		int[] a = new int[2];
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
		for(int i=0; i<numbers.length; i++) {
			Integer n = nums.get(numbers[i]);
			if(n == null) {
				nums.put(numbers[i], i);
			}
			n = nums.get(target - numbers[i]);
			if(n!=null && n<i) {
				a[0] = n;
				a[1] = i;
				return a;
			}
		}
		return a;
	}
}
