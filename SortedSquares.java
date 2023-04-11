/* 
Given an integer array nums sorted in non-decreasing order, return an 
array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: 5
-4 -1 0 3 10
Output:0 1 9 16 100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input:5
-7 -3 2 3 11
Output:4 9 9 49 121

*/
import java.util.*;
class SortedSquares
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++)
        a[i]=s.nextInt();
        int res[]=new int[n];
        int r=n-1,l=0,i=n-1;
        while(l<=r)
        {
            int ls=a[l]*a[l];
            int rs=a[r]*a[r];
            if(ls>rs)
            {
                res[i--]=ls;l++;
            }
            else 
            {
                res[i--]=rs;r--;
            }
        }
        for(int k=0;k<n;k++)
        System.out.print(res[k]+" ");
        s.close();
    }
}