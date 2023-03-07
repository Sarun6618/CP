import java.util.*;
class DFS1 
{
	static int n;
	static int visited[];
	static void dfs(int a[][],int v)
	{
		//logic
// 		int visited[]=new int[a.length];
		visited[v]=1;
		System.out.print(" "+v);
		for(int i=0;i<a.length;i++)
		{
		    if(visited[i]==0 && a[v][i]==1)
		    dfs(a,i);
		}
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		//read n, declare matrix, allocate memory to visited
		int n=s.nextInt(),a[][]=new int[n+1][n+1];
		visited=new int[n+1];
		System.out.println("Enter the adjacency matrix of the graph");
		//read matrix
		for(int i=1;i<=n;i++)
		{
		    for(int j=1;j<=n;j++) a[i][j]=s.nextInt();
		}
		System.out.println("Enter source vertex");
		//read source vertex
		int v=s.nextInt();
        s.close();
		dfs(a,v);		
	}
}
