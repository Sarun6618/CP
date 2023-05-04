import java.util.*;
public class CollapsingFind 
{
    static int p[];
    static int size[];

    public static int collapsingFind(int i) 
	{
        //logic
        int r=i;
        while(p[r]>=0)
        {
            r=p[r];
        }
        while(i!=r)
        {
            int s=p[i];
            p[i]=r;
            i=s;
        }
        return r;
    }

    

    public static void weightedUnion(int i, int j) 
	{
        //logic
        int ri=collapsingFind(i),rj=collapsingFind(j);
        if(ri==rj) return;
        if(size[ri]<size[rj])
        {
            p[ri]=rj;
            size[rj]+=size[ri];
        }
        else
        {
            p[rj]=ri;
            size[ri]+=size[rj];
        }
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of vertices");
		int n=s.nextInt();
		p = new int[n+1];
        size = new int[n+1];

        for (int i = 1; i <= n; i++)
		{
            p[i] = -1;
            size[i] = 1;
        }

		weightedUnion(3,1);
		weightedUnion(5,1);
		weightedUnion(9,5);
		weightedUnion(4,2);
		weightedUnion(6,4);
		weightedUnion(7,8);
		weightedUnion(10,8);
		for(int i=1;i<=n;i++)
		{
			System.out.print(p[i]+" ");
		}
		System.out.println();
        s.close();
	}
}