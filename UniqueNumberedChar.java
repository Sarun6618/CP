/* Given an array of integers arr, return true if the number of occurrences 
of each value in the array is unique or false otherwise.


input=6
a b b a a c
output=true
Explanation: The value a has 3 occurrences, b has 2 and c has 1. No two values 
have the same number of occurrences.


input=2
a b
output=false


input=10
e d a e a a a e j d
output=true
 
*/
import java.io.*;
import java.util.*;
class UniqueNumberedChar
{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        char[] c=new char[n];
        for(int i=0;i<n;i++) c[i]=br.readLine().charAt(0);
        System.out.println(UniquenoChar(c));
    }
    public static boolean UniquenoChar(char[] a)
    {
        HashMap<Character,Integer> m=new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            m.put(a[i], m.getOrDefault(a[i], 0)+1);
        }
        Set<Integer> set=new HashSet<Integer>(m.values());
        return set.size()==m.size();
    }
}