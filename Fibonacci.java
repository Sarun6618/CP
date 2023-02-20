import java.util.*;
class Fibonacci 
{
	static int fib(int n)
	{
		//logic
		if(n==1)
		return 0;
		if(n==2)
		return 1;
		else
		return fib(n-1)+fib(n-2);
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n value");
		//logic
		int n=s.nextInt();
		System.out.println(fib(n));
		s.close();
	}
}