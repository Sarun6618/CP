/* If you take an integer and form the product of its 
individual digits, you get a smaller number. Keep doing this 
and eventually you end up with a single digit.

The number of steps it takes to reach this point is known as 
the integer's multiplicative persistence. For example, 
347 has a persistence of 3: 3*4*7 = 84, 8*4 = 32, 3*2 = 6.

Devise a function that returns the persistence of an integer using
recursion

input=9
output=0

input=12
output=1

input=6788
output=6

*/

import java.util.*;
class PersistenceRecur  
{
	int persistence(int x)
	{
		//logic
		int sum=1;
		if(x<10)
		return 0;
		else
		{
		    while(x>0)
		    {
		        sum=sum*(x%10);
		        x/=10;
		    }
		}
		return 1+persistence(sum);
	}
	public static void main(String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
		//logic
		PersistenceRecur p=new PersistenceRecur();
		int n=sc.nextInt();
		System.out.println(p.persistence(n));
        sc.close();
	}
}