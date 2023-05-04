/*
Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
- Equality rule: 'p' == 'p'
- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.


Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"


*/
import java.util.*;
class LexSmallestEquivalentString 
{
	static int p[];
	public static String smallestEquivalentString(String A, String B, String S)
	{
		p=new int[26];
        //assign value to parent
        Arrays.fill(p,-1);
        
        for(int i = 0; i < A.length(); i++) 
		{
            //get the value of every character
            int a=A.charAt(i)-'a',b=B.charAt(i)-'a';
            //find its parent
            int p1=find(a),p2=find(b);
            //perform union by making smallest charater as parent
            if(p1<p2) p[p2]=p1;
            else if(p2<p1) p[p1]=p2;
        }
		StringBuilder sb = new StringBuilder();
        //read every character from the required string and add its root to sb
        for(int i=0;i<S.length();i++)
        {
            int c=S.charAt(i)-'a';
            sb.append((char)('a'+find(c)));
        }
        return sb.toString();
    }
    
    static int find(int i) 
	{
        //logic
        while(p[i]>=0) i=p[i];
        return i;
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String A=sc.next();
		String B=sc.next();
		String T=sc.next();
		System.out.println(smallestEquivalentString(A,B,T));
        sc.close();
	}
}