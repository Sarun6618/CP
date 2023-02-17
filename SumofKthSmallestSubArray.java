import java.util.*;
class SumofKthSmallestSubArray
{
    public static int kthSmallestSubarraySum(int[] nums, int k)
	{
        int min = Integer.MAX_VALUE, sum = 0;
       
		//find the min sum and max sum
		for(int i=0;i<nums.length;i++)
		{
		    if(nums[i]<min)
		    min=nums[i];
		    sum+=nums[i];
		}
		int low = min, high = sum;
		//logic
		while(low<high)
		{
		    int mid=(low+high)/2;
		    int c=countSubarrays(nums,mid);
		    if(c<k)
		    low=mid+1;
		    else
		    high=mid;
		}
        return low;
    }

    public static int countSubarrays(int[] nums, int threshold)
	{
        int count = 0;
        int sum = 0;
        int length = nums.length;
        int left = 0, right = 0;
        //logic
        while(right<length)
        {
            sum+=nums[right];
            while(sum>threshold)
            {
                sum-=nums[left];
                left++;
            }
            count+=(right-left)+1;
            right++;
        }
        return count;
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
		//declare n and array a[]
		int n=s.nextInt(),a[]=new int[n];
		System.out.println("Enter array elements");
		//read array elements
		for(int i=0;i<n;i++)
		a[i]=s.nextInt();
		System.out.println("Enter the required position");
		int k=s.nextInt();
		int ct=kthSmallestSubarraySum(a,k);

		System.out.println(ct);
		s.close();
	}
}
