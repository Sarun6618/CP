/*
Input:
Enter number of Strings
5
Enter Strings
cornfiled exefiled, mefiled profiled delfiled
Output:
filed
*/

import java.util.*;
public class CommonSuffix
{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s[]=new String[n];
        for(int i=0;i<n;i++){
          s[i]=sc.next();
        }
        String res[]=new String[n];
        for(int i=0;i<n;i++){
            String ni=s[i];
            char ch[]=ni.toCharArray();
            int j=0,k=ni.length()-1;
            while(j<k){
                char temp=ch[j];
                ch[j]=ch[k];
                ch[k]=temp;
                j++;
                k--;
            }
            res[i]=new String(ch);
            
        }
        Arrays.sort(res);
        String mi=res[0];
        String ki=res[n-1];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<mi.length();i++){
            if(mi.charAt(i)==ki.charAt(i)){
                sb.append(mi.charAt(i));
            }
            else{
                break;
            }
        }
        System.out.println(sb.reverse().toString());
        sc.close();
    }
}