package com.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public boolean isPalindrome(int x) {
		
		return(true);
		
	}

	public static void main(String[] args) {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
			Solution solution = new Solution();
			
			int x = 121;
			int qqq;
			boolean answer = false;
			int size;
			
			
			if(x < 0) {
				answer = false;
				
			} else {while(x > 0) {
				
				{
				qqq = (x%10);	
				x = (x / 10);
				arrayList.add(qqq);
				}
			}
			size = arrayList.size();
			
			
			for(int i = arrayList.size()-1; i >= 0; i--) {
				arrayList2.add(arrayList.get(i));
			}
			if(arrayList.equals(arrayList2)) {
				answer = true;}
			}
			System.out.println(answer);
	}
}

		

		
			
			
		


		
		
	


