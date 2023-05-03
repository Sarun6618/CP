import java.util.*;
public class WeightedUnion 
{
    static int p[];
    static int size[];

    public WeightedUnion(int n) 
	{
        p = new int[n+1];
        size = new int[n+1];

        for (int i = 1; i <=n; i++)
		{
            p[i] = -1;
            size[i] = 1;
        }
    }

    public int find(int i) 
	{
        //logic
        while(p[i]>0) i=p[i];
        return i;
    }

    public void wunion(int i, int j) 
	{
        //logic
        int ri=find(i),rj=find(j);
        if(ri==rj) return;
        if(size[ri]==size[rj])
        {
            p[rj]=ri;
            size[ri]=size[ri]+size[rj];
        }
        else
        {
            p[ri]=rj;
            size[rj]=size[ri]+size[rj];
        }
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of vertices");
		int n=s.nextInt();
		WeightedUnion wu=new WeightedUnion(n); 
		wu.wunion(3,1);
		wu.wunion(5,1);
		wu.wunion(9,5);
		wu.wunion(4,2);
		wu.wunion(6,4);
		wu.wunion(7,8);
		wu.wunion(10,8);
		for(int i=1;i<=n;i++)
		{
			System.out.print(p[i]+" ");
		}
        s.close();
	}
}
