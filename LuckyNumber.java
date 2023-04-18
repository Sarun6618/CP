/* 
Given an m x n matrix of distinct numbers, return lucky number in the matrix .

    A lucky number is an element of the matrix such that it is the minimum element 
    in its row and maximum in its column.   
     
    
    Example 1:    
    Input:3 3
    3 7 8
    9 11 13
    15 16 17
    Output:15
    Explanation: 15 is the only lucky number since it is the minimum in 
    its row and the maximum in its column.
    Example 2:
    
    Input:3 4 
    1 10 4 2
    9 3 8 7
    15 16 17 12
    Output:12
    Explanation: 12 is the only lucky number since it is the minimum in
    its row and the maximum in its column.
    Example 3:
    
    Input:2 2
    7 8
    1 2
    Output:7
    Explanation: 7 is the only lucky number since it is the minimum in 
    its row and the maximum in its column.
*/
import java.util.*;
class LuckyNumber
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),m=s.nextInt(),a[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) a[i][j]=s.nextInt();
        }
        System.out.println(Lucky(a,n,m));
        s.close();
    }
    public static int Lucky(int[][] a,int n,int m)
    {
        int rowMin[]=new int[n],colMax[]=new int[m];
        for(int i=0;i<n;i++)
        {
            rowMin[i]=Integer.MAX_VALUE;
            for(int j=0;j<m;j++)
            rowMin[i]=Math.min(rowMin[i],a[i][j]);
        }
        for(int j=0;j<m;j++)
        {
            colMax[j]=Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                colMax[j]=Math.max(colMax[j],a[i][j]);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]==rowMin[i] && a[i][j]==colMax[j])
                return a[i][j];
            }
        }
        return -1;
    }
}