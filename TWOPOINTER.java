import java.util.*;
class TWOPOINTER 
{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=s.nextInt();
        // int t=s.nextInt();
        // int[] res=Sum(a,t);
        // for(int i:res)
        // System.out.println(i);
        int k=s.nextInt();
        RotateByk(a,k);
        s.close();
    }
    // public static int[] Sum(int a[],int t)
    // {
    //     int i=0,j=a.length-1;
    //     while(i<j)
    //     {
    //         if(a[i]+a[j]>t) j--;
    //         if(a[i]+a[j]<t) i++;
    //         if(a[i]+a[j]==t) return new int[]{i,j};
    //     }
    //     return new int[]{-1,-1};
    // }
    public static void RotateByk(int a[],int k)
    {
        int n=a.length,ans[]=new int[n];
        k=k%n;
        int x=0,ind=0;
        for(int i=n-k;i<n;i++) ans[x++]=a[i];
        for(int j=x;j<=n;j++) ans[j]=a[ind++];
        for(int i=0;i<n;i++) System.out.println(ans[i]+" ");
    }
}
