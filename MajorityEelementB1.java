/* 
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.


Example 1:

Input: 3
3 2 3
Output: 3

Example 2:
Input: 7
2 2 1 1 1 2 2
Output: 2

*/
import java.util.*;
public class MajorityEelementB1 {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=s.nextInt();
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int i:a)
        {
            m.put(i,m.getOrDefault(i,0)+1);
            if(m.get(i)>(n/2))
            System.out.println(i);
        }
        s.close();
    }
}
