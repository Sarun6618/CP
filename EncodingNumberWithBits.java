/*
Given a non-negative integer num, Return its encoding string.
The encoding is done by converting the integer to a string using a secret function that
you should deduce from the following table:
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
class EncodingNumberWithBits 
{
    public static String encode(int num) 
	{
        int len = 0;
        //logic
        while(num>0)
        {
            if(num-(1<<len)<0)
            break;
            num-=1<<len++;
        }

        String ans="";
        //logic
        // //Method-1 using adding to string directly
        // if(num==0)
        // return ans;
        // return ans+Integer.toBinaryString(num);

        //Method-2 using bit operator
        while(num>0)
        {
            if((num&1)==1)
            ans="1"+ans;
            else
            ans=ans+"0";
            num>>=1;
        }
        return ans;

        //reverse and return
    }
    public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		System.out.println(encode(n));
        s.close();
	}
}