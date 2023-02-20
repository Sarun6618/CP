import java.util.*;
class  SumofnArray
{
	static int sum(int a[],int n)
	{
		//logic
		if(n<=0)
		return 0;
		else
		return a[n-1]+sum(a,n-1);
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the size of the array");
		//logic
		int n=s.nextInt(),a[]=new int[n];
		System.out.println("Enter the array values");
		//logic
		for(int i=0;i<n;i++)
		a[i]=s.nextInt();
		System.out.println(sum(a,n));
        s.close();
	}
}