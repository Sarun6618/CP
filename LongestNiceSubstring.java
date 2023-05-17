/*
A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. 
For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, 
but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.

*/
import java.util.*;
class LongestNiceSubstring 
{
    public static String longestNiceSubstring(String s) 
	{
	    //logic
	    String res="";
	    for(int i=0;i<s.length();i++)
	    {
	        for(int j=i+1;j<s.length();j++)
	        {
	            if(isNice(s.substring(i,j+1))&& j-i+1>res.length())
	            res=s.substring(i,j+1);
	        }
	    }
	    return res;
    }
    static boolean isNice(String s)
    {
        boolean l[]=new boolean[26],u[]=new boolean[26];
        for(char c:s.toCharArray())
        {
            if(Character.isLowerCase(c))
            l[c-'a']=true;
            else
            u[c-'A']=true;
        }
        for(int i=0;i<26;i++)
        {
            if(l[i]!=u[i]) return false;
        }
        return true;
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println(longestNiceSubstring(str));
        s.close();
	}
}
