import java.util.*;
class  GcdR
{
	static int gcd(int a,int b)
	{
		//logic
		if(b!=0)
		return gcd(b,a%b);
		else
		return a;
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 2 values");
		//logic
		int a=s.nextInt(),b=s.nextInt();
		System.out.println(gcd(a,b));
		s.close();
	}
}