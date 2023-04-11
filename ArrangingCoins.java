/* You have n coins and you want to build a staircase with these coins. 
The staircase consists of k rows where the ith row has exactly i coins. 
The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the 
staircase you will build.

 
Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
*/
import java.util.*;
class ArrangingCoins{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=0,i=1;
        while(n>0)
        {
            // c++;
            n=n-i;
            if(n>0)
            c++;
            i++;
        }
        System.out.print(c);
        sc.close();
    }
}