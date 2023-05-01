/*
Balanced strings are those that have an equal quantity of 'N' and 'G' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.
Input: s = "NGNNGGNGNG"
Output: 4
Explanation: s can be split into "NG", "NNGG", "NG", "NG", each substring 
contains same number of 'N' and 'G'.

Input: s = "NGNNNGGNGG"
Output: 2
Explanation: s can be split into "NG", "NNNGGNGG", each substring contains same 
number of 'N' and 'G'.

Input: s = "NNNNGGGG"
Output: 1
Explanation: s can be split into "NNNNGGGG".
*/
import java.util.*;
class BalancedStringsSplit 
{
    public static int balancedStringSplit(String s) 
	{
        //if length is 0
        if(s.length()==0) return 0;
        int N=0,G=0,ct=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='N') N++;
            if(s.charAt(i)=='G') G++;
            if(N==G) ct++;
        }
        return ct;
        
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println(balancedStringSplit(str));
        s.close();
	}
}
