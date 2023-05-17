import java.util.*;
class SortByBits 
{
    public static int[] sortByBits(int[] arr) 
    {
        int[] bits = new int[arr.length];
        int[] ans = new int[arr.length];
        //logic
        for(int i=0;i<arr.length;i++) bits[i]=Integer.bitCount(arr[i]);
        for(int i=0;i<arr.length;i++) ans[i]=arr[i];
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(bits[i]>bits[j] ||(bits[i]==bits[j] && ans[i]>ans[j]))
                {
                    int temp=ans[i];
                    ans[i]=ans[j];
                    ans[j]=temp;
                    temp=bits[i];
                    bits[i]=bits[j];
                    bits[j]=temp;
                }
            }
        }
        return ans;
    }
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		int ans[]=sortByBits(a);
		for(int i=0;i<ans.length;i++)
		{
			System.out.print(ans[i]+" ");
		}
        s.close();
	}
}