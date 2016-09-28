package com.singlenum3;

import java.util.HashMap;

public class SingleNumber3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int n : singleNumber3(new int[]{1, 2, 1, 3, 2, 5})) {
			System.out.println(n);
		}
		for(int n : singleNumber3(new int[]{-1, 0})) {
			System.out.println(n);
		}
	}
	
	public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int cnt = 0;
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
        	Integer n = numMap.get(nums[i]);
        	if(n == null) {
        		numMap.put(nums[i], i);
        	}
        	n = numMap.get(nums[i]);
        	if(n < i) {
        		numMap.put(1, n);
        	}
        }
        
        return res;
    }
	
	public static int[] singleNumber3(int[] nums) {
		int[] res = new int[2];  
        int result = nums[0];  
        for(int i=1;i<nums.length;i++){  
            result = result^nums[i];  
        }  
        res[0] = 0;  
        res[1] = 0;  
        int n = result & (~(result-1));  
        for(int i=0;i<nums.length;i++){  
            if((n & nums[i])!=0){  
                res[0] = res[0] ^ nums[i];  
            }else {  
                res[1] = res[1] ^ nums[i];  
            }  
        }  
        return res;
	}
}
