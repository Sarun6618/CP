/*
Given an integer array nums and an integer k, you are asked to construct the array ans of size n-k+1 where
ans[i] is the number of distinct numbers in the subarray nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]].
Return the array ans.

Example 1: Input: nums = [1,2,3,2,2,1,3], k = 3 Output: [3,2,2,2,3]
Explanation: The number of distinct elements in each subarray goes as follows:
- nums[0:2] = [1,2,3] so ans[0] = 3
- nums[1:3] = [2,3,2] so ans[1] = 2
- nums[2:4] = [3,2,2] so ans[2] = 2
- nums[3:5] = [2,2,1] so ans[3] = 2
- nums[4:6] = [2,1,3] so ans[4] = 3
*/

import java.util.*;
class DistinctNumbers
{
	public static int[] distinct(int a[],int k)
	{
		int n=a.length;
		int ans[]=new int[n-k+1];
		//logic
		int x=0;
		HashMap<Integer,Integer>m=new HashMap<>();
		for(int i=0;i<k;i++)
		{
		    m.put(a[i],m.getOrDefault(a[i],0)+1);
		}
		ans[x++]=m.size();
		for(int i=k;i<n;i++)
		{
		    int cur=a[i],prev=a[i-k];
		    m.put(prev,m.getOrDefault(prev,0)-1);
		    if(m.get(prev)==0)
		    m.remove(prev);
		    m.put(cur,m.getOrDefault(cur,0)+1);
		    ans[x++]=m.size();
		}
		return ans;
	}
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);

		System.out.println("Enter the size of the array");
		int n=s.nextInt();

		int a[]=new int[n];

		System.out.println("Enter array elements");
		//read array
		for(int i=0;i<n;i++)
		a[i]=s.nextInt();

		System.out.println("Enter the window size");
		//read size k
		int k=s.nextInt();


		int[] ans=distinct(a,k);

		for(int i=0;i<ans.length;i++)
			System.out.print(ans[i]+" ");
		System.out.println();
		s.close();
	}
}
