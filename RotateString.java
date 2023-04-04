/* 
Given two strings s and goal, return true if and only if s can become goal after 
some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:
Input: abcde   //string 
cdeab           //goal
Output: true

Example 2:
Input:abcde
abced
Output: false

*/
import java.io.*;
class RotateString
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine(),s2=br.readLine();
        if(s1.length()!=s2.length())
        {
            System.out.println(false);
            return;
        }
        String res=s1+s1;
        System.out.println(res.contains(s2));
    }
}