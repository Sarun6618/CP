import java.util.*;
class MaxAreaofIslandsDFS
{
	public static int maxAreaofIsland(int a[][])
	{
		int m=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				if(a[i][j]==1)
				{
					m=Math.max(m,maxArea(a,i,j));

				}
			}
		}
		return m;
	}
	public static int maxArea(int a[][],int i,int j)
	{
		//logic
		if(i<0||j<0||i>=a.length||j>=a[i].length||a[i][j]==0) return 0;
		a[i][j]=0;
		int ct=1;
		ct+=maxArea(a,i-1,j);
		ct+=maxArea(a,i,j+1);
		ct+=maxArea(a,i+1,j);
		ct+=maxArea(a,i,j-1);
		return ct;
	}

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of the vertices:");
		int n = s.nextInt();
		int a[][] =new int[n][n];
		System.out.println("Enter adjacency matrix");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=s.nextInt();
			}
		}
		int max=maxAreaofIsland(a);
		System.out.println(max);
        s.close();
	}
}