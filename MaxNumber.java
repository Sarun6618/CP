/* You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit 
(6 becomes 9, and 9 becomes 6).


Example 1:

Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.
*/
import java.util.*;
class MaxNumber
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.println(Maxnum(n));
        s.close();
    }
    public static int Maxnum(int n)
    {
        String ss=Integer.toString(n);
        int max=0;
        for(int i=0;i<ss.length();i++)
        {
            if(ss.charAt(i)=='6')
            {
                max=Math.max(Integer.parseInt(ss.substring(0,i)+'9'+ss.substring(i+1)),max);
                return max;
            }
        }
        return n;
    }
}