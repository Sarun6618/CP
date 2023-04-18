/* Write a java program for following scenario
Given an array arr of positive integers sorted in a strictly increasing order, 
and an integer k.

Return the kth positive integer that is missing from this array.

Example 1:
Input:5
2 3 4 7 11
5
Output: 9

Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. 
The 5th missing positive integer is 9.

Example 2:
Input:4
1 2 3 4
2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. 
The 2nd missing positive integer is 6.

*/
import java.util.*;
class KthMissingNo
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=s.nextInt();
        int k=s.nextInt();
        System.out.println(findKthMissing(a,n,k));
        s.close();
    }
    public static int findKthMissing(int[] a,int n,int k)
    {
        int mct=0,i=0,cur=1;
        while(mct<k)
        {
            if(i<a.length && a[i]==cur) i++;
            else mct++;
            if(mct==k) return cur;
            cur++;
        }
        return -1;
    }
}
