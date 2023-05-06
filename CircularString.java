/* 
A sentence is a list of words that are separated by a single space with no leading or
trailing spaces.

For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
Words consist of only uppercase and lowercase English letters. Uppercase and lowercase 
English letters are considered different.

A sentence is circular if:

The last character of a word is equal to the first character of the next word.
The last character of the last word is equal to the first character of the first word.

For example, "lite exercises sound delightful", 
"estate", "late eats soul" are all circular sentences. 
However, "Late is cool", "happy day", "kmit" and "I like kmit" are not circular sentences.

Given a string sentence, return true if it is circular. Otherwise, return false.

sample input/output
input=late eats soul
output=true

input=lite exercises sound delightful
output=true

input=I like kmit
output=false

*/
import java.util.*;
class CircularString
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String st=s.nextLine(),arr[]=st.split(" "),a=arr[0],b=arr[1],c=arr[arr.length-1];
        if((a.charAt(a.length()-1)==b.charAt(0)) && ((a.charAt(0))==c.charAt(c.length()-1)))
        System.out.print(true);
        else System.out.print(false);
        s.close();
    }
}