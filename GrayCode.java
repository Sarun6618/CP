import java.util.*;
public class GrayCode 
{
    public List<Integer> grayCode(int n) 
	{
        //logic
        List<Integer>l=new ArrayList<>();
        for(int i=0;i<(1<<n);i++)
        {
            int x=i^(i>>1);
            l.add(x);
        }
        return l;
    }

    public static void main(String args[]) 
	{
        Scanner s=new Scanner(System.in);
        System.out.println("Enter a value");
        int n=s.nextInt();
        GrayCode gc = new GrayCode();
        System.out.println(gc.grayCode(n));
        s.close();
    }
}