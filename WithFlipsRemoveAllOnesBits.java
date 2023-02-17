/*
We are given an m x n binary matrix grid.
In one operation, you can choose any row or column and flip each value in that 
row or column (i.e., changing all 0's to 1's, and all 1's to 0's).
Return true if it is possible to remove all 1’s from the grid using any number 
of operations or false otherwise.
Input: grid = [[0,1,0],[1,0,1],[0,1,0]]
Output: true
Explanation: One possible way to remove all 1's from grid is to:
- Flip the middle row
- Flip the middle column
*/
import java.util.*;
class  WithFlipsRemoveAllOnesBits
{
	public static boolean removeOnes(int grid[][]) 
	{
		//logic
		int r=grid.length,c=grid[0].length;
		int fr[]=grid[0],rr[]=reverse(fr);
		for(int i=1;i<r;i++)
		{
		    for(int j=0;j<c;j++)
		    {
		        if(grid[0][0]==grid[i][0])
		        {
		            if(fr[j]!=grid[i][j])
		            return false;
		        }
		        else
		        {
		            if(rr[j]!=grid[i][j])
		            return false;
		        }
		    }
		}
		return true;
	}

	public static int[] reverse(int[] row) 
	{
		//logic
		int rr[]=new int[row.length];
		for(int i=0;i<row.length;i++)
		rr[i]=row[i]^1;
		return rr;
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in); 
		System.out.println("Enter square matrix order"); 
		int n=s.nextInt();
		int grid[][]=new int[n][n]; 
		System.out.println("Enter the binary matrix"); 
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				grid[i][j]=s.nextInt();
			}
		}
		System.out.println(removeOnes(grid));
        s.close();
	}
}
