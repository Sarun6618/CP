/* 
Given a positive integer n, return the smallest positive integer that is a multiple
of both 2 and n.
 

Example 1:

Input:5
Output:10
Explanation: The smallest multiple of both 5 and 2 is 10.

Example 2:

Input:6
Output:6
Explanation: The smallest multiple of both 6 and 2 is 6. Note that a 
number is a multiple of itself.

*/
import java.util.*;
class EvenMultiple
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        s.close();
        for(int i=2;i<=2*n;i++)
        {
            if(i%2==0 && i%n==0)
            {
                System.out.print(i);
                return;
            }
        }
    }
}