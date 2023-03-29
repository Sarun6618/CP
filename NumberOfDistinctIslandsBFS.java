import java.util.*;
public class NumberOfDistinctIslandsBFS 
{
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int numDistinctIslands(int[][] grid) 
	{
        //logic
        HashSet<String> s=new HashSet<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    String island=bfs(grid,i,j);
                    s.add(island);
                }
            }
        }
        return s.size();
    }
    public static String bfs(int grid[][],int i,int j)
    {
        Queue<int[]> q=new java.util.LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j]=0;
        StringBuilder sb=new StringBuilder();
        sb.append("o");
        while(!q.isEmpty())
        {
            int[] cur=q.poll();
            for(int[] dir:DIRS)
            {
                int x=cur[0]+dir[0],y=cur[1]+dir[1];
                if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==1)
                {
                    sb.append(dir[0]);
                    sb.append(dir[1]);
                    q.offer(new int[]{x,y});
                    grid[x][y]=0;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) 
	{
        Scanner sc=new Scanner(System.in);
		System.out.println("Enter the order of the grid");
		int m=sc.nextInt();
		int n=sc.nextInt();
		System.out.println("Enter the island values");
		int a[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		System.out.println(numDistinctIslands(a)); 
        sc.close();
    }
}