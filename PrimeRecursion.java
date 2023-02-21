import java.util.*;
class PrimeRecursion
{
	static boolean primeno(int num, int i)
	{
		//logic
		if(i<=num/2)
		{
		    if(num%i==0)
		    return false;
		    return primeno(num,i+1);
		}
		return true;
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number:");
		//logic
		int n=s.nextInt();
		System.out.println(primeno(n,2));
        s.close();
	}
}
