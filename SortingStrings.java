/*
input=blooms taxonomy critical thinking skills                                                                                
output=gnikniht lacitirc slliks smoolb ymonoxat     
*/
import java.util.*;
class SortingStrings 
{
	public static void main(String[] args) 
	{
		//logic
		Scanner s=new Scanner(System.in);
		String st=s.nextLine();
		String[] a=st.split(" ");
		for(int w=0;w<a.length;w++)
		{
		    char[] c=a[w].toCharArray();
		    int i=0,j=c.length-1;
		    while(i<=j)
		    {
		        char temp=c[i];
		        c[i]=c[j];
		        c[j]=temp;
		        i++;j--;
		    }
		    a[w]=new String(c);
		}
		Arrays.sort(a);
		System.out.println(String.join(" ",a));
        s.close();
	}
}