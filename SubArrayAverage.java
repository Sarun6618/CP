/*Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
Given an array of integers arr and two integers k and threshold, return the 
number of sub-arrays of size k and average greater than or equal to threshold.


Example 1:
Input:8 
a = [2,2,2,2,5,5,5,8] 
k = 3
threshold = 4
Output: 3

Explanation: 

size of the array
array elements
window size
threshold value
Output

Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
All other sub-arrays of size 3 have averages less than 4 (the threshold).


Example 2:
Input: a = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. 
Note that averages are not integers.*/

import java.util.*;
class SubArrayAverage 
{
    public static int numOfSubarrays(int a[], int k, int threshold)
	{
        //logic
        double s=0;
        int ct=0;
        for(int i=0;i<k;i++) s=s+a[i];
        if(s/k>=threshold) ct++;
        for(int i=k;i<a.length;i++)
        {
            s+=a[i]-a[i-k];
            if(s/k>=threshold) ct++;
        }
        return ct;
    }
	public static void main(String[] args) 
	{
		//logic
		Scanner s=new Scanner(System.in);
		int n=s.nextInt(),a[]=new int[n];
		for(int i=0;i<n;i++) a[i]=s.nextInt();
		int k=s.nextInt(),t=s.nextInt();
		System.out.println(numOfSubarrays(a,k,t));
        s.close();
	}
}
