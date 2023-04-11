/* You are given an integer array deck where deck[i] represents the number written on the ith card.

Partition the cards into one or more groups such that:

Each group has exactly x cards where x > 1, and
All the cards in one group have the same integer written on them.
Return true if such partition is possible, or false otherwise.

 

Example 1:
Input: 8
1 2 3 4 4 3 2 1
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:
Input: 8
1 1 1 2 2 2 3 3
Output: false
Explanation: No possible partition.

*/
import java.util.*;
class Partition
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++)
        a[i]=s.nextInt();
        System.out.println(hasGroups(a));
        s.close();
    }
    public static boolean hasGroups(int a[])
    {
        HashMap<Integer,Integer>m=new HashMap<>();
        for(int i:a)
        m.put(i,m.getOrDefault(i,0)+1);
        int mf=Integer.MAX_VALUE;
        for(int i:m.values())
        mf=Math.min(mf,i);
        for(int i=2;i<=mf;i++)
        {
            boolean isCD=true;
            for(int j:m.values())
            {
                if(j%i!=0)
                {
                    isCD=false;
                    break;
                }
            }
            if(isCD) return true;
        }
        return false;
    }
}