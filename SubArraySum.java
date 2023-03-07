/*Subarray Sum Less Than K
Given an array of integers nums and an integer k,return the number of contiguous
subarrays where the sum of all the elements in the subarray is strictly less than k.

Example 1:

Input: 4
nums = [10,5,2,6],
k = 18
Output: 9
Explanation: The 9 subarrays that have sum less than 18 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [10,5,2], [5, 2, 6]

Explanation:
Size of the array
elelemnts of the array
window size
Output

Example 2:

Input: nums = [1,2,3], k = 2
Output: 1*/

import java.util.*;
class  SubArraySum
{
	public static int numSubarraySumLessThanK(int a[], int k) 
	{
        //logic
        int ct=0,i=0,j=0,s=0;
        for(;j<a.length;j++)
        {
            s+=a[j];
            while(i<a.length && s>k)
            {
                s-=a[i];
                i++;
            }
            ct+=j-i+1;
        }
        return ct;
    }
	public static void main(String[] args) 
	{
		//logic
		Scanner s=new Scanner(System.in);
		int n=s.nextInt(),nums[]=new int[n];
		for(int i=0;i<n;i++) nums[i]=s.nextInt();
		int k=s.nextInt();
		System.out.println(numSubarraySumLessThanK(nums,k));
        s.close();
	}
}
