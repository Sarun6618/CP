/*
Example 1: 
Given s = "internationalization", abbr = "i12iz4n": Return true. 
Example 2: Given s = "apple", abbr = "a2e": Return false.
*/
import java.util.*;

class ValidAbbreviation 
{
    public static boolean validity(String word, String abbr) 
	{
		int i=0,j=0;
		if(word==null||abbr==null)
			return false;
		//logic
		while(i<word.length() && j<abbr.length())
		{
		    if(Character.isDigit(abbr.charAt(j)))
		    {
		        if(abbr.charAt(j)=='0')
		        return false;
		        else
		        {
		            int sum=0;
		            while(j<abbr.length() && Character.isDigit(abbr.charAt(j)))
		            {
		                sum=sum*10+(abbr.charAt(j)-'0');
		                j++;
		            }
		            i+=sum;
		        }
		    }
		    else
		    {
		        if(word.charAt(i)!=abbr.charAt(j))
		        return false;
		        i++;j++;
		    }
		}
		return i==word.length()&&j==abbr.length();
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter word");
		String word=sc.next();
		System.out.println("Enter abbreviation");
		String abbr=sc.next();
		System.out.println(validity(word,abbr));
        sc.close();
	}
}