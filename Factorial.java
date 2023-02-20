import java.util.*;
class Factorial 
{
	static long fact(int n)
	{
		//logic
		if(n==0)
		return 1;
		else
		return n*fact(n-1);
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n value");
		//logic
		int n=s.nextInt();
		System.out.println(fact(n));
		s.close();
	}
}