import java.util.*;
class BFS1 
{
	static int q[]=new int[20];
	static int f=-1,r=-1;

	static void qinsert(int x)
	{
		//logic
		r++;
		q[r]=x;
		if(f==-1) 
		f=0;
	}

	static int qdelete()
	{
		if(f==-1)
			return 0;
		int x=q[f];
		if(f==r) 
		{f=-1;r=-1;}
		else f++;
		//logic
		return x;
	}

	static void bfs(int a[][],int v)
	{
        //logic
        int visited[]=new int[a.length];
        qinsert(v);
        visited[v]=1;
        while(true)
        {
            for(int i=1;i<a.length;i++)
            {
                if(a[v][i]==1&&visited[i]==0)
                {
                    qinsert(i);
                    visited[i]=1;
                }
            }
            v=qdelete();
            if(v!=0)
            System.out.print(" "+v);
            if(f==-1)
            return;
            v=q[f];
        }
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		//read n
		int n=s.nextInt();
		//declare adjacency matrix
		int a[][]=new int[n+1][n+1];
		System.out.println("Enter the adjacency matrix of the graph");
		//read matrix
		for(int i=1;i<=n;i++)
		{
		    for(int j=1;j<=n;j++)
		    {
		        a[i][j]=s.nextInt();
		    }
		}
		System.out.println("Enter source vertex");
		//read source vertex
		int v=s.nextInt();
        s.close();
		bfs(a,v);		
	}
}
