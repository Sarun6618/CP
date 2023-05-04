/*
Sample Input-1:
---------------
5
4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 
6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 
*/

import java.util.*;

class ConnectedComponentsUF 
{
	int[] parent;
	int[] size;
    public int countComponents(int n, int[][] edges)
    {
        parent = new int[n];
        size = new int[n];
        //initialize parent and size
        Arrays.fill(parent,-1);
        Arrays.fill(size,1);
        
        int components = n;
        for (int[] e : edges)
		{
            //find parents of e[0] and e[1]
            int p1=find(e[0]),p2=find(e[1]);
            //if parents are not equal perform union based on size 
            if(p1!=p2)
            {
                if(size[p1]<size[p2])
                {
                    parent[p1]=p2;
                    size[p2]+=size[p1];
                }
                else
                {
                    parent[p2]=p1;
                    size[p1]+=size[p2];
                }
                components--;
            }
            //decrement components
        }
        return components;
    }
    private int find(int i) 
	{
		//logic
		while(parent[i]>=0) i=parent[i];
		return i;
    }
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		int edges[][]=new int[e][2]; 
		for(int i=0;i<e;i++)
			for(int j=0;j<2;j++)
				edges[i][j]=sc.nextInt();
		System.out.println(new ConnectedComponentsUF().countComponents(n,edges));
        sc.close();
	}	
}


