/*
Given a value print the first n elements of the series
input=10
output=0 1 1 2 4 7 13 24 44 81
*/
import java.util.*;
class TriboSeries 
{
	public static void main(String[] args) 
	{
		//logic
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
	    int a[]=new int[n];
	    a[0]=0;a[1]=1;a[2]=1;
	    for(int i=3;i<n;i++)
	    {
	        a[i]=a[i-1]+a[i-2]+a[i-3];
	    }
	    for(int i=0;i<n;i++)
	    System.out.print(a[i]+" ");
        s.close();
	}
}
