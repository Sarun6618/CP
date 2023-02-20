import java.util.*;
class UniqueChar {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String st=s.next();
        s.close();
        for(int i=0;i<st.length();i++)
        {
            if(st.indexOf(st.charAt(i))==st.lastIndexOf(st.charAt(i)))
            {
                System.out.println(st.charAt(i));
                System.exit(0);
            }
        }
        System.out.println(-1);
    }    
}
