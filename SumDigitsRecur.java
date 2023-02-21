/* Create a function that takes a number and returns one digit 
that is the result of summing all the digits of the input number. 
When the sum of the digits consists of more than one digit, 
repeat summing until you get one digit.

Note: Use Recursion

Examples
input=123
output=6
// 1 + 2 + 3 = 6

input=999
output=9

input=123
output=6
*/

import java.util.*;
class SumDigitsRecur 
{
	int sumdigit(int n)
	{
		//logic
		int sum=0;
		if(n<10)
		return n;
		else
		{
		    while(n>0)
		    {
		        sum+=n%10;
		        n/=10;
		    }
		}
		return sumdigit(sum);
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		//logic
		SumDigitsRecur s=new SumDigitsRecur();
		int n=sc.nextInt();
		System.out.println(s.sumdigit(n));
        sc.close();
	}
}