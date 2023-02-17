import java.util.*;
class MaxOfallsuba
{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++)
        a[i]=s.nextInt();
        int k=s.nextInt();
        int ct=0;
        int ans[]=new int[n-k+1];
        for(int i=0;i<n-k+1;i++)
        {
            int max=a[i];
            for(int j=i+1;j<i+k;j++)
            {
                if(max<a[j])
                max=a[j];
            }
            ans[ct++]=max;
        }
        for(int i=0;i<n-k+1;i++)
        System.out.println(ans[i]);
        s.close();
    }
}