/*
Given a non-negative integer num, Return its encoding string.
The encoding is done by converting the integer to a string using a secret 
function that you should deduce from the following table:
N f(n)
0 “ ”
1 “0”
2 “1”
3 “00”
4 “01”
5 “10”
6 “11”
7 “000”
Example 1:
Input: num = 23
Output: “1000”

Example 2:
Input: num = 107
Output: “101100”
*/
import java.util.*;
class EncodingNumberWithoutBits 
{
	public static String encode(int num)
	{ 
		//logic
		int x=0;
		while(num>0)
		{
		    if((num-Math.pow(2,x)<0))
		    break;
		    num-=Math.pow(2,x++);
		}
		String res=""; 
		//logic
		if(num==0)
		return res;
		else
		return res+Integer.toBinaryString(num);
	}
    public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		System.out.println(encode(n));
        s.close();
	}
}