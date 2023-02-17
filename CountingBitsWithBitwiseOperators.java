/*Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <=
n), ans[i] is the number of 1's in the binary representation of i.
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101*/

import java.util.*;
class CountingBitsWithBitwiseOperators 
{
    public static int[] countBits(int n)
    {
        //create an array r of size n+1 
        int r[]=new int[n+1];
        r[0]=0;
        for(int i=1;i<=n;i++)
        {
            int ct=0,x=i;
            while(x>0)
            {
                ct=ct+(x&1);
                x=x>>1;
            }
            r[i]=ct;
        }
        //logic
        return r;
    }
    public static void main(String[] args) 
    {
    	Scanner s=new Scanner(System.in);
    	int n=s.nextInt();
    	int r[]=new int[n+1];
    	r=countBits(n);
    	for(int i=0;i<=n;i++)
    	System.out.println(" "+r[i]);
        s.close();
    }
}