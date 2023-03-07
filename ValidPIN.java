/* Wrie a Java program  that will test if a string is a valid PIN or not 
A valid PIN has:

Exactly 4 or 6 characters.
Only numeric characters (0-9).
No whitespace.
Examples input/ouptu
121317
true


45135
false

Note: use nextLine method
*/
import java.util.*;
class ValidPIN
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String st=s.nextLine();
        boolean t=true;
        if(st.length()==4 || st.length()==6)
        {
            for(int i=0;i<st.length();i++)
            {
                if(!Character.isDigit(st.charAt(i)))
                {
                    t=false;
                }
            }
            System.out.println(t);
        }
        else System.out.println(!t);
        s.close();
    }
}