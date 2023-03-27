/* Create a program that converts a phone number with letters 
to one with only numbers.

Number	Letter
0	none
1	none
2	ABC
3	DEF
4	GHI
5	JKL
6	MNO
7	PQRS
8	TUV
9	WXYZ
Examples
123-647-EYES
123-647-3937

(325)444-TEST
(325)444-8378

653-TRY-THIS
653-879-8447

All inputs will be formatted as a string representing a proper phone 
number in the format XXX-XXX-XXXX or (XXX)XXX-XXXX, using numbers and 
capital letters.
*/
import java.util.*;
class PhoneNumber
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String st=s.next().toUpperCase(),op="";
        s.close();
        for(int i=0;i<st.length();i++)
        {
            char c=st.charAt(i);
            if(Character.isLetter(c))
            {
                int d=getDigit(c);
                if(d>=0) op+=d;
                else {System.out.println("Invalid input");return;}
            }
            else if(Character.isDigit(c) || c=='-'||c=='('||c==')') op+=c;
            else {System.out.println("Invalid input");return;}
        }
        System.out.println(op);
    }
    public static int getDigit(char c)
    {
        switch(c)
        {
            case 'A':case 'B':case 'C':return 2;
            case 'D':case 'E':case 'F':return 3;
            case 'G':case 'H':case 'I':return 4;
            case 'J':case 'K':case 'L':return 5;
            case 'M':case 'N':case 'O':return 6;
            case 'P':case 'Q':case 'R':case 'S':return 7;
            case 'T':case 'U':case 'V':return 8;
            case 'W':case 'X':case 'Y':case 'Z':return 9;
            default:return -1;
        }
    }
}