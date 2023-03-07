/*Program to check whether a number is power of 2 or not
Sample Input/Output
Input:64
Output:true
Input:-1
Output:false
Input:0
Output:false
Input:126
Output:false
*/
import java.util.*;
class PowerofTwo 
{
	public static boolean isPowerOfTwo(int n) 
	{
        //logic
        if(n!=0 && (n&n-1)==0) return true;
        else return false;
    }
	public static void main(String[] args) 
	{
	    //logic
	    Scanner s=new Scanner(System.in);
	    int n=s.nextInt();
	    System.out.println(isPowerOfTwo(n));
		s.close();
	}
}
