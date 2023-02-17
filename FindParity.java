import java.util.*;
class  FindParity
{
	static int parityDiff(int n1, int n2)
	{
        //logic
		// int ct=0;
		// String s=Integer.toBinaryString(n1^n2);
		// for(int i=0;i<s.length();i++)if(s.charAt(i)=='1') ct++;//s.charAt(i)!='0'
		// return ct;
        int x=(n1^n2);
		int ct=0;
		while(x>0){
		    ct=ct+(x&1);
		    x=x>>1;
		}
        return ct;
        // StringBuilder sb=new StringBuilder();
        // String s=Integer.toBinaryString(n1^n2);
        // for(int i=0;i<s.length();i++){
        // if(s.charAt(i)=='0')continue;
        // else sb.append(s.charAt(i));
        // }
        // return sb.length();
        // int x=n1,y=n2,ct=0;
        // while(x!=0 && y!=0)
        // {
        //     int r1=x%10,r2=y%10;
        //     if((r1^r2)==0)
        //     {
        //         ct++;
        //         x=x/10;
        //         y=y/10;
        //     }
        // }
        // return ct;
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 2 values");
		int n1=s.nextInt();
		int n2=s.nextInt();
		System.out.println(parityDiff(n1,n2));
        s.close();
	}
}