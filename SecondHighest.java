/*Second Largest Digit in a String
Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 
if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.

Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit. 

*/

import java.util.*;
class  SecondHighest
{
    public static int secondHighest(String s) 
	{
        //logic
        int fir=0,sec=-1;
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                if(s.charAt(i)-'0'>fir)
                {
                    sec=fir;
                    fir=s.charAt(i)-'0';
                }
            }
        }
        return sec;
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println(secondHighest(str));
        s.close();
	}
}
