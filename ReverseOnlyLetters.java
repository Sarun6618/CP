/* 


Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Note: use two pointer approch to solve above problem

Example 1:
Input:=ab-cd
Output=dc-ba

Example 2:
Input:=a-bC-dEf-ghIj
Output=j-Ih-gfE-dCba

*/
import java.util.*;
class ReverseOnlyLetters
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        char[] a=s.next().toCharArray();
        int i=0,j=a.length-1;
        while(i<j)
        {
            if(!Character.isLetter(a[i])) i++;
            if(!Character.isLetter(a[j])) j--;
            else
            {
                char temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;j--;
            }
        }
        String st=a.toString();
        System.out.println(st);
        s.close();
    }
}