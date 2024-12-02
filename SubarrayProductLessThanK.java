package com.app.wise;

public class SubarrayProductLessThanK {

	/*
	 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
----------------------
Intuition

    Initialization: Initialize variables i and j to 0, prod to 1, and ans to 0. These variables are used to track the current subarray, the product of elements in the subarray, and the count of valid subarrays, respectively.

    Main Loop: The main loop iterates through the array using the j index. It multiplies the current product (prod) by nums[j] in each iteration.

    Inner While Loop: If the product (prod) becomes greater than or equal to k, it means the current subarray product is too large. In this case, the inner while loop reduces the subarray size by dividing prod by nums[i] and increments i until prod becomes less than k again.

    Counting Subarrays: After adjusting the subarray size, the code calculates the number of valid subarrays by adding j-i+1 to ans. This formula counts all subarrays that end at index j and have a product less than k.

    Incrementing j: Finally, the outer loop increments j to consider the next element in the array and repeats the process until j reaches the end of the array.

Overall, this algorithm efficiently counts the number of subarrays with a product less than k by using two pointers (i and j) to dynamically adjust the subarray size based on the product condition.
Code

 
	 */
	
	   public int numSubarrayProductLessThanK(int[] nums, int k) {

	        int i = 0;
	        int n = nums.length;
	        int j = 0;
	        int prod=1;
	        int ans =0;

	        while(j<n)
	        {
	            prod = prod*nums[j];

	            while(prod>=k && i<=j)
	            {
	                prod/=nums[i];
	                i++;
	            }
	            ans += j-i+1;
	            j++;
	        }
	        return ans;
	    }
}
