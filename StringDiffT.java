/* Little Jai loves presents. His mum bought him two strings of the same size
for his birthday. The strings consist of uppercase and lowercase English letters. 
Now Jai wants to compare those two strings lexicographically. 
The letters case does not matter, that is an uppercase letter is considered
equivalent to the corresponding lowercase letter. 
Help Jai to perform the comparison by writing a Java program.

Input
Each of the first two lines contains a bought string. The strings' lengths
range from 1 to 100 inclusive. It is guaranteed that the strings are 
of the same length and also consist of uppercase and lowercase 
English letters.

Output
If the first string is less than the second one, print "-1". 
If the second string is less than the first one, print "1". 
If the strings are equal, print "0". 

Note that the letters' case is not taken into consideration when 
the strings are compared.

Sample input/output:
aaaa
aaaA        //input
0           //output
*/
import java.util.*;
class StringDiffT
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String c=s.next(),d=s.next();
        String a=c.toLowerCase(),b=d.toLowerCase();
        s.close();
        if(a.length()!=b.length()) return;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
            {
                if(a.charAt(i)>b.charAt(i))
                {
                    System.out.println(1);return;
                }
                if(a.charAt(i)<b.charAt(i))
                {
                    System.out.println(-1);return;
                }
            }
        }
        System.out.println(0);
    }
}