import java.util.*;
public class twopointerbruteforce {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++)
        a[i]=s.nextInt();
        int x=s.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i]+a[j]==x)
                {
                    System.out.println(i+" "+j);
                    System.exit(0);
                }
            }
        }
        System.out.println(-1+" "+-1);
        s.close();
    }    
}
