/* Write a program to convert a binary String to decimal number 
using recursion.
Sample input: 0111
ouput=7

input=1010
output=10
*/
import java.util.*;
class BinaryToDecimal
{
	int bintoDecimal(char binary[],int len, int i)
	{
	    //logic
	    if(i==len-1)
	    return binary[i]-'0';
	    int sum=binary[i]-'0';
	    sum=sum<<(len-i-1);
	    return sum+bintoDecimal(binary,len,i+1);
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		//read string
		String s=sc.next();
		//convert to array
		char st1[]=s.toCharArray();
		//compute length
		int length=st1.length;
		System.out.println(new BinaryToDecimal().bintoDecimal(st1,length,0));
        sc.close();
	}
}