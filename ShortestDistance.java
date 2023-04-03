/* 
Given a string s and a character c that occurs in s, return an array of integers 
answer where answer.length == s.length and answer[i] is the distance from index i 
to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute 
value function.

 

Example 1:
Input:kmit
t
Output: [3, 2, 1, 0]
 
Example 2:
Input:aaab
b
Output: [3, 2, 1, 0]

*/
import java.io.*;
class ShortestDistance
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        char c=(char)br.read();
        int[] ans=new int[st.length()];
        // int f=-1;
        // Method-1
        // for(int i=0;i<st.length();i++)
        // {
        //     if(st.charAt(i)==c)
        //     {
        //         f=i;
        //         break;
        //     }
        // }
        int f=st.indexOf(c);
        for(int i=0;i<st.length();i++)
        {
            ans[i]=f==-1?-1:Math.abs(f-i);
        }
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
    }
}