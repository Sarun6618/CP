/*You are given an integer array nums with the following properties:

nums.length == 2 * n.
nums contains n + 1 unique elements.
Exactly one element of nums is repeated n times.
Return the element that is repeated n times.

 

Example 1:
Input:4 
1 2 3 3
Output: 3
Example 2:

Input:6
2 1 2 5 3 2
Output: 2
Example 3:

Input:8
5 1 5 2 5 3 5 4
Output: 5
 
*/
import java.util.*;
class RepeatedElement
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=s.nextInt();
        HashMap<Integer,Integer>m=new HashMap<>();
        for(int i:a)
        {
            m.put(i,m.getOrDefault(i,0)+1);
            if(m.get(i)==n/2)
            {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(-1);
        s.close();
    }
}