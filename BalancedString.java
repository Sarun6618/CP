/* Balanced strings are those that have an equal quantity of 'C' and 'S' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.

input=SCSSCCSCSC
output=4
Explanation: s can be split into "SC", "SSCC", "SC", "SC", each 
substring contains same number of 'C' and 'S'.


input=SCSSSCCSCC
output=2
Explanation: s can be split into "SC", "SSSCCSCC", each substring 
contains same number of 'C' and 'S'.
Note that s cannot be split into "SC", "SS", "SC", "CS", "CC", 
because the 2nd and 5th substrings are not balanced.


input=CCCCSSSS
output=1
Explanation: s can be split into "CCCCSSSS".
 */
import java.io.*;
class BalancedString
{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        System.out.println(maxBalancedString(st));
    }
    public static int maxBalancedString(String st)
    {
        int ct=0,b=0;
        for(int i=0;i<st.length();i++)
        {
            if(st.charAt(i)=='C') b++;
            else b--;
            if(b==0) ct++; 
        }
        return ct;
    }
}