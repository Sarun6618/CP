/*Minimum Average Subarray 
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the minimum 
average value and return this value. 
Any answer with a calculation error less than 10-5 will be accepted.

input=8
2 3 -1 8 9 6 2 4
4  
output=3.0

Explanation: 
8 is input size
list elements
4 is window size 

*/
//package
import java.util.*;
class  MinAverage
{	
	public static double minAvgSubarray(int a[], int k)
	{	
		//logic
		double s=0,arr[]=new double[a.length-k+1];
		for(int i=0;i<k;i++) s+=a[i];
		arr[0]=s/k;
		for(int i=k;i<a.length;i++)
		{
		    s+=a[i]-a[i-k];
		    arr[i-k+1]=s/k;
		}
		double min=Double.MAX_VALUE;
		for(int i=0;i<arr.length;i++)
		{
		    if(arr[i]<min)
		    min=arr[i];
		}
		return min;
	}
	public static void main(String[] args) 
	{
	    //logic
	    Scanner s=new Scanner(System.in);
	    int n=s.nextInt(),a[]=new int[n];
	    for(int i=0;i<n;i++) a[i]=s.nextInt();
	    int k=s.nextInt();
	    System.out.println(minAvgSubarray(a,k));
        s.close();
	}
}
