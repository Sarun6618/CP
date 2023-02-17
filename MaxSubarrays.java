/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very
left of the array to the very right. You can only see the k numbers in the window. Each time the sliding
window moves right by one position.
Return the max sliding window. Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position           Max
------------------------ -----
[1 3 -1] -3 5 3 6 7       3
1 [3 -1 -3] 5 3 6 7       3
1 3 [-1 -3 5] 3 6 7       5
1 3 -1 [-3 5 3] 6 7       5
1 3 -1 -3 [5 3 6] 7       6
1 3 -1 -3 5 [3 6 7]       7
*/
import java.util.*;

public class MaxSubarrays
{
    private static int[] maxofAllSubarray(int[] a, int k)
	{
        //declare n and store length
        int n=a.length;
        //declare ans[] array
        int ans[]=new int[n-k+1];
        //declare an idx variable
        int idx=0;
        //create a PriorityQueue which stores elements in reverse order
        PriorityQueue<Integer>q=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<k;i++)
        q.add(a[i]);
        ans[idx++]=q.peek();
        for(int i=k;i<n;i++)
        {
            int prev=a[i-k],cur=a[i];
            q.remove(prev);
            q.add(cur);
            ans[idx++]=q.peek();
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("enter array elements size");
        //read n
        int n=s.nextInt(),a[]=new int[n];
        //declare array a[] and allot memory
        System.out.println("enter the elements");
        //read array elements
        for(int i=0;i<n;i++)
        a[i]=s.nextInt();

        System.out.println("enter the subarray size");
        //read window size
        int k=s.nextInt();

        int[] ans  = maxofAllSubarray(a, k);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
        s.close();
    }
}