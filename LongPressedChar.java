/* 
Your friend is typing his name into a keyboard. Sometimes, when typing a character c, 
the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that 
it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:
Input:alex
aaleex
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input:saeed
ssaaedd
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.

*/
import java.io.*;
class LongPressedChar
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String name=br.readLine(),typed=br.readLine();
        int i=0,j=0;
        while(i<name.length()&&j<typed.length())
        {
            if(name.charAt(i)==typed.charAt(j))
            {
                i++;j++;
            }
            else if(j>0 && typed.charAt(j)==typed.charAt(j-1))
            {
                j++;
            }
            else
            {
                System.out.println(false);
                return;
            }
        }
        while(j<typed.length() && typed.charAt(j)==typed.charAt(j-1)) j++;
        boolean ans=(i==name.length()&&j==typed.length());
        System.out.println(ans);
        
    }
}