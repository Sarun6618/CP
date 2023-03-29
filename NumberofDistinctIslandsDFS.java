import java.util.*;

class NumberofDistinctIslandsDFS 
{
    static int m,n;
	static int baserow,basecol;
	
    public static int numDistinctIslands(int[][] a) 
	{
        //logic
        HashSet<String> s=new HashSet<>();
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                if(a[i][j]==0)
                continue;
                StringBuilder sb=new StringBuilder();
                baserow=i;
                basecol=j;
                path(a,i,j,sb);
                s.add(sb.toString());
                
            }
        }
        return s.size();
        
    }
	public static void path(int a[][],int row,int col,StringBuilder sb)
	{
		//logic
		if(row<0||col<0||row>=a.length||col>=a[0].length||a[row][col]==0) return;
		a[row][col]=0;
		sb.append(""+(row-baserow)+(col-basecol));
		sb.append(",");
		path(a,row-1,col,sb);
		path(a,row,col+1,sb);
		path(a,row,col-1,sb);
		path(a,row+1,col,sb);
		
	}
    public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the order of the grid");
		int m=sc.nextInt();
		int n=sc.nextInt();
		System.out.println("Enter the island values");
		int a[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		System.out.println(numDistinctIslands(a));
        sc.close();
	}
}