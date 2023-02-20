import java.util.*;
class SumofTwo 
{
	public static int sum(int a,int b)
	{
		//logic
		if(b==0)
		return 0;
		else
		return a+b;
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 2 positive values");
		//logic
		int a=s.nextInt(),b=s.nextInt();
		System.out.println(sum(a,b));
		s.close();
	}
}