import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.*;
class SegmentTree {
    public static int[] constructST(int st[],int a[],int si,int l,int u)
    {
        if(l==u)
        {
            st[si]=a[l];
            return st;
        }
        int mid=(l+u)/2;
        st=constructST(st,a,2*si+1,l,mid);
        st=constructST(st,a,2*si+2,mid+1,u);
        st[si] = st[2 * si + 1] + st[2 * si + 2];
        return st;
    }
    // public static int getSum(int st[],int si,int sl,int su,int l,int u)
    // {
    //     if(l<=sl & u>=su) return ;

    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no of elements:");
        int n=Integer.parseInt(br.readLine()),a[]=new int[n];
        System.out.println("Enter elements of array:");
        for(int i=0;i<n;i++) 
        a[i]=Integer.parseInt(br.readLine());
        System.out.println("Enter Segment starting index:");
        int si=Integer.parseInt(br.readLine());
        System.out.println("Enter l and u values:");
        int l=Integer.parseInt(br.readLine()),u=Integer.parseInt(br.readLine());
        int x = (int) (Math.ceil(Math.log(n+1) / Math.log(2)));
        // System.out.println(x);
        int max_size = 2 * (int) Math.pow(2, x)-1;
        // System.out.println(max_size);
        int[] st = new int[max_size];
        st = constructST(st,a,si,l,u);
        for (int i = 0; i < max_size; i++) {
            System.out.print(st[i] + " ");
        }
        System.out.println();
    }
}
