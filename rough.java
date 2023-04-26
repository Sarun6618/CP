import java.util.*;
class rough
{
    // static int n;
    static int visited[];
    static void dfs(int a[][],int v)
    {
        visited[v]=1;
        System.out.println(v);
        for(int i=1;i<a.length;i++)
        {
            if(visited[i]==0 && a[v][i]==1) dfs(a,i);
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[][]=new int[n+1][n+1];
        visited=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                a[i][j]=s.nextInt();
            }
        }
        int ct=0;
        // int v=s.nextInt();
        for(int i=1;i<=n;i++)
        {
            if(visited[i]==0)
            {
                dfs(a,i);
                ct++;
            }
        }
        System.out.println(ct);
        s.close();
        // dfs(a,v);
    }
}