import java.util.*;
class NaiveSumofKthSmallestSubArray
{
    public static int kthSmallestSubarraySum(int[] nums, int k)
	{
		int n=nums.length;
		ArrayList<Integer> al=new ArrayList<>();
		//logic
		for(int m=1;m<=n;m++)
		{
		    for(int i=0;i<n-m+1;i++)
		    {
		        int s=0;
		        for(int j=i;j<i+m;j++)
		        {
		            s+=nums[j];
		        }
		        al.add(s);
		    }
		}
        /*
        Method-2 O(n2)
        for(int i=0;i<n;i++)
        {
            int s=0;
            for(int j=i;j<n;j++)
            {
                s+=a[j];
                ls.add(s);
            }
        }
        Method-3
        for(int i=1;i<=n;i++)
        {
            int s=0;
            for()
        }
         */
		Collections.sort(al);
		return al.get(k-1);
    }
   	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
		int n=s.nextInt();
		
		int a[]=new int[n];
		
		System.out.println("Enter array elements");
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		
		System.out.println("Enter the position k");
		int k=s.nextInt();

		int ct=kthSmallestSubarraySum(a,k);

		System.out.println(ct);
		s.close();
	}
}