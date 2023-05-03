import java.util.*;
public class UnionFind
{
	static int n;
	static int p[];
	static int find(int i)
	{
	    //logic
	    while(p[i]>0) i=p[i];
	    return i;
	}
	static void union(int i,int j)
	{
		//logic
		int ri=find(i),rj=find(j);
		if(ri==rj) return;
		p[ri]=rj;
	}

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of vertices");
		n=s.nextInt();
		p=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			p[i]=-1;
		}
		union(3,1);
		union(5,1);
		union(9,5);
		union(4,2);
		union(6,4);
		union(7,8);
		union(10,8);
		for(int i=1;i<=n;i++)
		{
			System.out.print(p[i]+" ");
		}
		System.out.println();
        s.close();
	}
}
