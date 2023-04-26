import java.util.*;
class ConnectedComponents 
{
	static int n;
	static int visited[];
	static void dfs(int a[][],int v)
	{
		//logic
		visited[v]=1;
// 		System.out.println(v);
		for(int i=1;i<a.length;i++)
		{
		    if(visited[i]==0 && a[v][i]==1)
		    {
		        dfs(a,i);
		    }
		}
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		//logic
		int n=s.nextInt();
		int a[][]=new int[n+1][n+1];
		visited=new int[n+1];
        System.out.println("Enter the adjacency matrix of the graph");
		//logic
		for(int i=1;i<=n;i++)
		{
		    for(int j=1;j<=n;j++)
		    {
		        a[i][j]=s.nextInt();
		    }
		}
		int c=0;
		//logic
		for(int i=1;i<=n;i++)
		{
		    if(visited[i]==0)
		    {
		        c++;
		        dfs(a,i);
		    }
		}
		System.out.println(c);
		s.close();
	}
}
