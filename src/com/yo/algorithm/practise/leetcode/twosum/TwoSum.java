package com.yo.algorithm.practise.leetcode.twosum;

import java.util.HashMap;

public class TwoSum {

	/**
	 * @LeetCode��1�� TwoSum,����һ�������int������target��
	 * ��������ֵ��ӵ�target���������������е�λ�ã�����һ�������������±������
	 * �磺nums={2�� 7�� 11�� 15}��target=9���򷵻ص�����Ϊ{0�� 1}
	 */
	public static void main(String[] args) {
		int[] nums = {0, 4, 3, 0};
		for(int a : twoSum2(nums, 7)) {
			System.out.println(a);
		}
			
	}
	/**
	 * O(n^2)��ʱ�临�Ӷ� 
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
	 * O(n)��ʱ�临�Ӷ� 
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
