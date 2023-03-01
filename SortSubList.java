/*Write a Java Program to sort the sublist of a given List in ascending or 
descending order. User should be able to specify the order.
Sample Input/Output:
Input:Enter number of elements
6
Enter n values
1 4 3 20 15 6
Enter start and end positions
1 4
Enter the order ascending/descending
a
[1, 3, 4, 15, 20, 6]

Note: If start is less than 0 or greater than end or end > n-1 then return -1
if(s<0&e>n-1&s>e)
{
	System.out.println("-1");
	return;
}
*/

import java.util.*;
class SortSubList 
{
	public static ArrayList sortsublist(int[] a,int s,int e,char ch)
	{
		//logic
		ArrayList<Integer> al=new ArrayList<>();
		if(ch=='a')
		{
		    PriorityQueue<Integer>p=new PriorityQueue<>();
		    for(int i=s;i<=e;i++)
		    p.add(a[i]);
		    for(int i=s;i<=e;i++)
		    a[i]=p.poll();
		}
		else
		{
		    PriorityQueue<Integer>p=new PriorityQueue<>(Comparator.reverseOrder());
		    for(int i=s;i<=e;i++)
		    p.add(a[i]);
		    for(int i=s;i<=e;i++)
		    a[i]=p.poll();
		}
		for(int i=0;i<a.length;i++)
		al.add(a[i]);
		return al;
	}
	public static void main(String[] args) 
	{
		//logic
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n=s.nextInt(),a[]=new int[n];
		System.out.println("Enter n values");
		for(int i=0;i<n;i++) a[i]=s.nextInt();
		System.out.println("Enter start and end positions");
		int f=s.nextInt(),l=s.nextInt();
		if(f<0 ||l>n-1||f>l)
		{
		    System.out.println("-1");
		    System.exit(0);
		}
		System.out.println("Enter the order ascending/descending");
		char c=s.next().charAt(0);
        s.close();
		System.out.println(sortsublist(a,f,l,c));
	}
}



