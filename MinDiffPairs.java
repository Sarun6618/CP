/*
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
1) a, b are from arr
2) a < b
3) b - a equals to the minimum absolute difference of any two elements in arr

Input: 
4 //size of the array
4 2 1 3 //array elements
Output: 
1,2
2,3
3,4
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
*/

import java.util.*;
class MinDiffPairs 
{
	public static void main(String[] args) 
	{
		//logic
		Scanner s=new Scanner(System.in);
		int n=s.nextInt(),a[]=new int[n];
		for(int i=0;i<n;i++) a[i]=s.nextInt();
		Arrays.sort(a);
		int minDiff=Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++)
		{
		    minDiff=Math.min(minDiff,(a[i+1]-a[i]));
		}
		for(int i=0;i<n-1;i++)
		{
		    if(a[i+1]-a[i]==minDiff)
		    System.out.println(a[i]+","+a[i+1]);
		}
        s.close();
	}
}
