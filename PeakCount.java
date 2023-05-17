/*Given a matrix of order m*n find the number of peak positions in the matrix. 
A position (i,j) is called peak if mat[i][j]==1 and all other elements in row i 
and col j are 0*/

import java.util.*;
class PeakCount
{
    public static int numSpecial(int[][] mat) 
    {
        //logic
        int s=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1 && checkRow(i,mat) && checkColumn(j,mat)) s++;
            }
        }
        return s;
    }

    static boolean checkRow(int i, int[][] mat)
    {
        //logic
        for(int j=0;j<mat[0].length;j++)
        {
            if(mat[i][j]!=0 && j!=i) return false;
        }
        return true;
    }

    static boolean checkColumn(int j, int[][] mat)
    {
        //logic
        for(int i=0;i<mat.length;i++)
        {
            if(mat[i][j]!=0 && i!=j) return false;
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
             a[i][j]=s.nextInt();
        }
        System.out.println(numSpecial(a));
    }
}


