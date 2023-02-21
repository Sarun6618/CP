import java.util.*;
class Largest
{
	static int large(int a[], int size, int lst)
	{
		//logic
		if(size==0)
		return lst;
		return large(a,size-1,Math.max(lst,a[size]));
		
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the size of the array");
		//read size and array 
		int n=s.nextInt(),a[]=new int[n];
		System.out.println("Enter the array values");
		//read array
		for(int i=0;i<n;i++)
		a[i]=s.nextInt();
		//store the first value
		int l=large(a,n-1,a[0]);
		System.out.println(l);
        s.close();
	}
}