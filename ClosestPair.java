/*
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element 
from each array. We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair
ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum. 

Example-1:
Input: a[] = {1, 4, 5, 7};
b[] = {10, 20, 30, 40};
x = 32
Output: 1 and 30

Example-2:
Input: a[] = {1, 4, 5, 7};
b[] = {10, 20, 30, 40};
x = 50
Output: 7 and 40
*/

import java.util.*;

class ClosestPair
{
	public static void  printClosest(int a[], int b[], int m, int n, int x)
	{
		// Initialize the diff between pair sum and x.

		int diff = Integer.MAX_VALUE;
		int i_pos=0;
		int j_pos=b.length-1;
		int i=0;
		int j=b.length-1;
		while(i_pos<a.length && j_pos>=0){
		    int sum=a[i_pos]+b[j_pos];
		    int mins=Math.abs(x-sum);
		    if(mins<diff){
		        diff=mins;
		        i=i_pos;
		        j=j_pos;
		    }
		    if(sum>x){
		        j_pos--;
		    }
		    else{
		        i_pos++;
		    }
		}

		// res_l and res_r are result indexes from ar1[] and ar2[] respectively
		
		// Start from left side of ar1[] and right side of ar2[]
		
		// If this pair is closer to x than the previously found closest, then update res_l, res_r and diff
		
		

		// If sum of this pair is more than x, move to smaller side

		// move to the greater side
		
		// Print the result
		System.out.print("The closest pair is [" + a[i] +	", " + b[j] + "]");
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

        System.out.println("enter size of array1");
        int n=sc.nextInt();
        int a[]=new int[n];
        //logic

        System.out.println("enter the values of array1");
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
          //logic
		  System.out.println("enter size of array2");
		  int m=sc.nextInt();
		  int b[]=new int[m];
        //logic
        System.out.println("enter the values of array2");
        for(int i=0;i<m;i++)b[i]=sc.nextInt();
          //logic
           System.out.println("enter closest number");
           int x=sc.nextInt();
           //logic
		printClosest(a, b, m, n, x);
        sc.close();
	}
}