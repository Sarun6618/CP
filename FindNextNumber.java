/* 
This problem was asked by Facebook.
Given an integer n, find the next biggest integer with the same number of 1-bits on. 
For example, given the number 6 (0110 in binary), return 9 (1001).

Sample Input/Output
Input=12
Outpu=17
*/

import java.util.*;
class FindNextNumber 
{
	public static int countEqualBits(int n)
    {
		//logic
		int b=Integer.bitCount(n);
		while(true)
		{
		    int a=Integer.bitCount(n+1);
		    if(a==b) return n+1;
		    n=n+1;
		}
    }
	public static void main(String[] args) 
	{
		//logic
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		System.out.println(countEqualBits(n));
        s.close();
	}
}
