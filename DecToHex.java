/*
Bob was having a good habit of working with numbers. Daily he used to give a 
task to his brother based on numbers. One day he gave an integer and asked his 
brother to convert the number into its equivalent hexadecimal representation.
Help his brother to convert by writng a java program. The program should work 
properly even if a negative number is given as input. Do not use any built-in 
functions.Lower case alphabets must be used and leading zeeros must not be 
present.

Input: num = 26
Output: "1a"

Input: num = -1
Output: "ffffffff"
*/
import java.util.*;
class DecToHex
{
    static char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String toHex(int n) 
    {
        //logic
        String str="";
        long o=n;
        if(n<0)
        {
            o=4294967296l+n;
        }
        while(o!=0)
        {
            int r=(int)(o%16);
            str=hex[r]+str;
            o/=16;
        }
        return str;
    }
    public static void main(String args[])
    {
        //logic
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.println(toHex(n));
        s.close();
    }
 }