import java.util.*;
class Sumofn 
{
	static int sum(int n)
	{
		//logic
		if(n==0)
		return 0;
		else
		return n+sum(n-1);
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number");
		//logic
		int n=s.nextInt();
		System.out.println(sum(n));
		s.close();
	}
}