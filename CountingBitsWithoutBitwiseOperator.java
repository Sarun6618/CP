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
class CountingBitsWithoutBitwiseOperator 
{
    public static int[] countBits(int n) 
	{
        //create an array R of size n+1
        int R[]=new int[n+1];
        R[0]=0;
        for(int i=1;i<=n;i++)
        {
            if(i%2==0)
            {
                R[i]=R[i/2];
            }
            else
                R[i]=R[i/2]+1;
        }
        //store the number of 1's in the array
        
        return R;
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
