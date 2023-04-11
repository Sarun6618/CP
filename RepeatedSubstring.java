/* 
Given a string s, check if it can be constructed by taking a substring of it 
and appending multiple copies of the substring together.

 
Example 1:
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Example 2:
Input: s = "aba"
Output: false


Example 3:
Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

*/


import java.util.*;
public class RepeatedSubstring{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next(); 
        int n = s.length(),sz=1,x=n/2;
        boolean val = false;  
        for(int i=0;i<x;i++){
            String temp = s.substring(0,sz); 
            int j=0;
            while(j<n && (j+sz<=n)){ 
                if(s.substring(j,j+sz).equals(temp)==false){
                    break;
                }
                j+=sz; 
            }
            if(j==n){
                val = true;
            } 
            sz++;
        }
        System.out.print(val);
        sc.close();
    }
}