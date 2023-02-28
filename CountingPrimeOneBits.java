/*
Given two integers begin and end, return the count of numbers in the inclusive 
range [begin,end] having a prime number of 1 bits in their binary representation.
For example, 21 written in binary is 10101, which has three 1 bits.
Input:10
15
Output:5
*/
import java.util.*;
class CountingPrimeOneBits
{
	public static boolean isPrime(int n)
	{
		//logic
		if(n==0||n==1)
		return false;
		for(int i=2;i<=n/2;i++)
		{
		    if(n%i==0)
		    return false;
		}
		return true;
	}
    public static int countBits(int begin,int end)
    {
		//logic
		int c=0;
		for(int i=begin;i<=end;i++)
		{
		    if(isPrime(Integer.bitCount(i))) c++;
		}
		return c;
    }
    public static void main(String[] args) 
    {
        //logic
        Scanner s=new Scanner(System.in);
        int b=s.nextInt(),e=s.nextInt();
        System.out.println(countBits(b,e));
		s.close();
    }
}