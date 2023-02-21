import java.util.*;
class Lcm
{
    //declare a variable and initialize to 1
	static int c=1;
 	static int lcm(int a, int b)
	{ 
	    if(c%a==0 && c%b==0)
	    return c;
	    else
	    c++;
	    return lcm(a,b);
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 2 values");
		//logic
		int a=s.nextInt(),b=s.nextInt();
		System.out.println(lcm(a,b));
        s.close();
	}
}
