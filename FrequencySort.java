 /*
 Sort Array by Increasing Frequency
 Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 If multiple values have the same frequency, sort them in decreasing order.
 Return the sorted array.
 
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
*/

import java.util.*;
class FrequencySort 
{
    public static int[] frequencySort(int[] nums) 
	{
        //logic
        Map<Integer,Integer> m=new HashMap<>();
        for(int i:nums) m.put(i,m.getOrDefault(i,0)+1);
        Queue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(m.get(a)!=m.get(b)) return m.get(a)-m.get(b);
            else return b-a;
        });
        for(int n:nums) pq.offer(n);
        int sortedarr[]=new int[nums.length],i=0;
        while(!pq.isEmpty()) sortedarr[i++]=pq.poll();
        return sortedarr;
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++)
			nums[i]=s.nextInt();
		int l[]=frequencySort(nums);
		for(int i=0;i<n;i++)
			System.out.print(l[i]+" ");
        s.close();
	}
}
