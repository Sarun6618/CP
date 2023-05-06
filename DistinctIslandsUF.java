import java.util.*;
import java.util.LinkedList;
public class DistinctIslandsUF 
{

private int size[];
private int p[];
private int N, M;

public int find(int i) 
{
	//logic
	while(p[i]>=0) i=p[i];
	return i;
}

public void union(int i, int j) 
{
	//logic
	int ri=find(i),rj=find(j);
	if(ri==rj) return;
	if(size[ri]<size[rj])
	{
	    p[rj]=ri;
	    size[ri]+=size[rj];
	}
	else
	{
	    p[ri]=rj;
	    size[rj]+=size[ri];
	}
}

private boolean inside(int x, int y) 
{
	//logic
	return (x>=0 && y>=0 && x<N && y<M);
}

public int numIslands(int grid[][]) 
{
	if (grid == null || grid.length ==0) return 0;
	N = grid.length;
	M = grid[0].length;
	size = new int[N*M];
	p = new int[N*M];
	
	//initilize p and size
	Arrays.fill(p,-1);
	Arrays.fill(size,1);
	
	List<int[]> ones = new ArrayList<>();
    //logic for combining 1's into sets
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<M;j++)
        {
            if(grid[i][j]==1)
            {
                int pos[]=new int[2];
                pos[0]=i;
                pos[1]=j;
                ones.add(pos);
                int temp=i*M+j;
                if(inside(i-1,j) && grid[i-1][j]==1)
                union(temp,temp-M);
                if(inside(i,j+1) && grid[i][j+1]==1)
                union(temp,temp+1);
                if(inside(i,j-1) && grid[i][j-1]==1)
                union(temp,temp-1);
                if(inside(i+1,j) && grid[i+1][j]==1)
                union(temp,temp+M);
            }
        }
    }
	 HashMap<Integer, Queue<int[]>> map = new HashMap<>();
        //populate map
        for(int pos[]:ones)
        {
            int x=pos[0],y=pos[1];
            int p1=find(x*M+y);
            Queue<int[]> q=map.getOrDefault(p1,new LinkedList<int[]>());
            q.add(pos);
            map.put(p1,q);
        }
        
        
        HashSet<String> strs = new HashSet<>();
        //store into hashset
        for(int k:map.keySet())
        {
            StringBuilder sb=new StringBuilder();
            Queue<int[]> q=map.get(k);
            int d[]=q.peek();
            int dx=d[0],dy=d[1];
            while(!q.isEmpty())
            {
                int cur[]=q.remove();
                sb.append(cur[0]-dx);
                sb.append(",");
                sb.append(cur[1]-dy);
                sb.append(";");
            }
            strs.add(sb.toString());
        }
        return strs.size();
    }
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int grid[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				grid[i][j]=sc.nextInt();
        System.out.println(new DistinctIslandsUF().numIslands(grid));
        sc.close();
	}
}