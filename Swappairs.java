/* lPaeesh le pemu mnxit ehess rtnisg! Oh, sorry, that was supposed to 
say: Please help me unmix these strings!

Somehow my strings have all become mixed up; every pair of characters
has been swapped. Help me undo this so I can understand my strings again.
by writing a java program.

Examples
123456
214365

hTsii  s aimex dpus rtni.g
This is a mixed up string.

badce
abcde


**Notes
The length of a string can be odd — in this case the last character 
is not altered (as there's nothing to swap it with).
*/
import java.util.*;
class Swappairs
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        char[] c=a.toCharArray();
        int n=a.length()%2==0?a.length():a.length()-1;
        for(int i=0;i<n;i+=2)
        {
            char t=c[i];
            c[i]=c[i+1];
            c[i+1]=t;
        }
        String st="";
        for(char q:c) st+=q;
        System.out.println(st);
        s.close();
    }
}