/* Create a java program that takes an input of increasing letters and return the missing letter.

Examples
a,b,c,e,f,g
d

O,Q,R,S
P

Notes
--Tests will always have exactly one letter missing.
--The length of the input will always be at least two.
--Tests will be in one particular case (upper or lower but never both).
*/

import java.util.*;
class MissingChar{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        sc.close();
        //int n=sc.nextInt();
        String s=sc.next();
        System.out.println(s);
        StringBuilder bc=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==',')
                continue;
            else
            {
                bc.append(s.charAt(i));
            }
        }
        String res=bc.toString();
        System.out.println(res);
        char ch[]=res.toCharArray();
        int i=0;
       // int j=0;
        while(i<ch.length-1){
            int a=ch[i];
            int b=ch[i+1];
            if((b-a)==1){
                i++;
            }
            else
            {
                int c=a+1;
                char d=(char)(c);
                System.out.print(d);
                break;
            }
        }
    }
}