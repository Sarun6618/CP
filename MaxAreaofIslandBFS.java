import java.util.*;

public class MaxAreaofIslandBFS {

    public static int getMaxArea(int[][] grid) 
	{
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) 
		{
            for (int j = 0; j < grid[0].length; j++) 
			{
                if (grid[i][j] == 1) 
				{
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private static int bfs(int[][] grid, int row, int col) 
	{
        //logic
        Queue<int[]> q=new java.util.LinkedList<>();
        int r=row,c=col;
        q.offer(new int[]{r,c});
        int area=0;
        while(!q.isEmpty())
        {
            int x[]=q.poll();
            r=x[0];
            c=x[1];
            if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]==0) continue;
            grid[r][c]=0;
            area++;
            q.offer(new int[]{r-1,c});
            q.offer(new int[]{r,c-1});
            q.offer(new int[]{r,c+1});
            q.offer(new int[]{r+1,c});
        }
        return area;
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
		System.out.println(getMaxArea(a));
        s.close();
    }
}