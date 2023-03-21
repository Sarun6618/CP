import java.util.*;
class SLIDINGWINDOW
{
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt(),a[]=new int[n];
    for(int i=0;i<n;i++) a[i]=s.nextInt();
    int k=s.nextInt();
    // int l=s.nextInt(),u=s.nextInt();
    // System.out.println(Diet(a,k,l,u));
    // int[] res=Distinct(a,k);
    // for(int i=0;i<n-k+1;i++)
    // System.out.println(res[i]);
    // int[] res=MaxSubArr(a,k);
    // for(int i=0;i<n-k+1;i++)
    // System.out.println(res[i]);
    // System.out.println(kthSmallest(a, k));
    System.out.println(kthSmallestSubarraySum(a, k));
    s.close();
  }
  // public static int Diet(int[] a,int k,int l,int u)
  // {
  //   int n=a.length,p=0,s=0;
  //   for(int i=0;i<k;i++) s+=a[i];
  //   if(s>u) p++;
  //   if(s<l) p--;
  //   for(int i=k;i<n;i++)
  //   {
  //     s+=a[i]-a[i-k];
  //     if(s>u) p++;
  //     if(s<l) p--;
  //   }
  //   return p;
  // }
  // public static int[] Distinct(int[] a,int k)
  // {
  //   int n=a.length,res[]=new int[n-k+1],x=0;
  //   HashMap<Integer,Integer>m=new HashMap<>();
  //   for(int i=0;i<k;i++)
  //   {
  //     m.put(a[i],m.getOrDefault(a[i], 0)+1);
  //   }
  //   res[x++]=m.size();
  //   for(int i=k;i<n;i++)
  //   {
  //     int prev=a[i-k],cur=a[i];
  //     m.put(prev,m.getOrDefault(prev, 0)-1);
  //     if(m.get(prev)==0) m.remove(prev);
  //     m.put(cur, m.getOrDefault(cur,0)+1);
  //     res[x++]=m.size();
  //   }
  //   return res;
  // }
  // public static int[] MaxSubArr(int[] a,int k)
  // {
  //   int n=a.length,x=0,res[]=new int[n+k-1];
  //   PriorityQueue<Integer>q=new PriorityQueue<>(Comparator.reverseOrder());
  //   for(int i=0;i<k;i++) q.add(a[i]);
  //   res[x++]=q.peek();
  //   for(int i=k;i<n;i++)
  //   {
  //     int prev=a[i-k],cur=a[i];
  //     q.remove(prev);
  //     q.add(cur);
  //     res[x++]=q.peek();
  //   }
  //   return res;
  // }
  // public static int kthSmallest(int a[],int k)
  // {
  //   int n=a.length,min=Integer.MAX_VALUE,s=0;
  //   for(int i=0;i<n;i++)
  //   {
  //     if(a[i]<min) min=a[i];
  //     s+=a[i];
  //   }
  //   int l=min,u=s;
  //   while(l<u)
  //   {
  //     int mid=(l+u)/2;
  //     int ct=countSub(a,mid);
  //     if(ct<k)
  //     l=mid+1;
  //     else u=mid;
  //   }
  //   return l;
  // }
  // public static int countSub(int a[],int threshold)
  // {
  //   int ct=0,s=0,len=a.length,left=0,right=0;
  //   while(right<len)
  //   {
  //     s+=a[right];
  //     while(s>threshold)
  //     {
  //       s-=a[left];
  //       left++;
  //     }
  //     ct+=(right-left)+1;
  //     right++;
  //   }
  //   return ct;   
  // }
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
}