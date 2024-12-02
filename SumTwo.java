package com.app.wise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumTwo {
//Input: nums = [2,7,11,15], target = 9
	
	public static int[] numToIndexMap(int[] array,int target) {
	  
		Map<Integer, Integer> numToIndexMap=new HashMap<Integer, Integer>();

		int sizeOfArray=array.length;
		for(int i=0;i<sizeOfArray;i++) {
			
			int diff=target-array[i];//9-2=7
			//9-7=2
			if(numToIndexMap.containsKey(diff))
			{
				return new int[] {numToIndexMap.get(diff),i};
			}
			numToIndexMap.put(array[i], i);
		}
		return null;
		
		
		
	}
	public static int[] bruteForceSumOfTwo(int[] nums,int target) {
		
		int sizeOfArray=nums.length;
		for(int i=0;i<sizeOfArray;i++) {
			for(int j=i+1;j<sizeOfArray;j++) {
				
				if(nums[i]+nums[j]==target) {
					
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		int[] nums = {2,15,11,7};
		int target = 9;
		
		int[] sum=numToIndexMap(nums,target);
	    System.out.println(Arrays.toString(sum));
	    
	    System.out.println("**********************************");
	    int[] sum1= bruteForceSumOfTwo(nums,target);
	    System.out.println(Arrays.toString(sum1));

	}
}
