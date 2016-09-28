package com.countbits;

import java.util.ArrayList;
/*
 * LeetCode第338题，CountingBits（给出一个非负数，计算0到该数每个数二进制中含1的个数，如5，
 * 返回结果【0,1，1,2,1,2】）(思路，构建一个栈，通过栈求每个数的二进制，再对其中1的个数进行判断)
 */
public class CountBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int a : new CountBits().countBits(2))
			System.out.println(a);
	}
	
	public int[] countBits(int num) {
		ArrayList<String> bits = new ArrayList<String>();
		int cnt = 0;
		MyStack s = new MyStack(100);
		for(int i=0; i<=num; i++) {
			if(i == 0) {
				bits.add(0 + "");
				continue;
			}
			getBinary(s, i);
			int bitsSum = 0;
			while(s.top >= 0) {
				if(s.pop() == 1) {
					bitsSum++;
				}
			}
			bits.add(bitsSum + "");
		}
		int[] bitsArray = new int[bits.size()];
		for(int i=0; i<bitsArray.length; i++) {
			bitsArray[i] = Integer.parseInt(bits.get(i));
		}
		return bitsArray;
	}
	
	public static void getBinary(MyStack s, int num) {
		int temp = num;
		while(temp/2 != 0) {
			s.push(temp%2);
			temp /= 2;
		}
		s.push(1);
	}

}
class MyStack {
    int data[];
    int maxSize;
    int top = -1;
    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
    }
    public boolean push(int num) {
        if(top+1 > maxSize) {
            return false;
        }
        data[++top] = num;
        return true;
    }
    public int pop() {
        if(top < 0) {
//            throw new Exception("栈已满");
        	return -1;
        }
        return data[top--];
    }
}
