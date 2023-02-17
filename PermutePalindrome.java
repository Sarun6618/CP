import java.util.*;
class  PermutePalindrome
{
    static boolean canPermutePalindrome(String s) 
	{
        //logic
        int m=0;
        for(int i=0;i<s.length();i++)
        {
            m=m^(1<<(s.charAt(i)-'a'));
        }
        return (m==0)|(m & m-1)==0;
    }
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a string");
		String str=s.next();
		System.out.println(canPermutePalindrome(str));
        s.close();
	}
}
