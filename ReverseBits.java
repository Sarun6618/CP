/*
Given an unsigned integer n we are asked to print the value after reversing all the 
bits of the number. i.e Reverse bits of a given 32 bits unsigned integer.
Input: 2
Output:1073741824
Input:15
Output:4026531840
Input:2147483647
Output:4294967294
*/

import java.util.*;
class  ReverseBits
{
	public static long reverseBits(int n) 
	{
		//logic
		long val=0;
// 		long rev=0;
		for(int i=0;i<32;i++)
		{
		    val=val<<1;
		    int x=(n&1);
		    val+=x;
		  //  rev<<=2;
		  //  rev|=(n&1);
		    n>>=1;
		}
		return val;
// 		return rev;
	}
	
	public static void main(String[] args) 
	{
		//logic
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		System.out.println(reverseBits(n));
        s.close();
	}
}
