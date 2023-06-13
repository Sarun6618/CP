import java.util.*;
class practice {
    public static int DietPlan(int a[],int k,int u,int l)
    {
        int p=0,sum=0,n=a.length;
        for(int i=0;i<k;i++) sum+=a[i];
        if(sum>u) p++;
        else if(sum<l) p--;
        for(int i=k;i<n;i++)
        {
            sum+=a[i]-a[i-k];
            if(sum>u) p++;
            else if(sum<l) p--;
        }
        return p;
    }
    public static boolean rowcolflip(int[][] a)
    {
        int r=a.length,c=a[0].length;
        int[] fr=a[0],rr=reverse(fr);
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(a[0][0]==a[i][0])
                {
                    if(fr[j]!=a[i][j]) return false;
                }
                else
                {
                    if(rr[j]!=a[i][j]) return false;
                }
            }
        }
        return true;
    }
    public static int[] reverse(int[] fr)
    {
        int n=fr.length;
        int[] rr=new int[n];
        for(int i=0;i<n;i++)
        {
            rr[i]=fr[i]^1;
        }
        return rr;
    }
    static class TrieNode
    {
        boolean isEnd;
        TrieNode arr[];
        TrieNode()
        {
            arr=new TrieNode[26];
            isEnd=false;
        }
    }
    static TrieNode root;
    public practice()
    {
        root=new TrieNode();
    }
    public static void insert(String word)
    {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(node.arr[ch-'a']==null)
            {
                TrieNode cur=new TrieNode();
                node.arr[ch-'a']=cur;
            }
            node=node.arr[ch-'a'];
        }
        node.isEnd=true;
    }
    public static boolean search(String word)
    {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(node.arr[ch-'a']==null) return false;
            node=node.arr[ch-'a'];
        }
        return node.isEnd;
    }
    public static boolean startsWith(String prefix)
    {
        TrieNode node=root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch=prefix.charAt(i);
            if(node.arr[ch-'a']==null) return false;
            node=node.arr[ch-'a'];
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        //Diet Plan
        // int n=s.nextInt(),a[]=new int[n];
        // for(int i=0;i<n;i++) a[i]=s.nextInt();
        // int k=s.nextInt(),l=s.nextInt(),u=s.nextInt();
        // System.out.println(DietPlan(a, k, u, l));
        //FlipRowsCols
        // int n=s.nextInt(),a[][]=new int[n][n];
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         a[i][j]=s.nextInt();
        //     }
        // }
        // System.out.println(rowcolflip(a));
        String str[]=new String[6];
		for(int i=0;i<10;i++)
		{
			str[i]=s.next();
			insert(str[i]);
		}
		System.out.println("Enter string to search");
		String s1=s.next();
		System.out.println(search(s1));
		System.out.println("Enter prefix");
		String s2=s.next();
		System.out.println(startsWith(s2));
        s.close();
    }
}
