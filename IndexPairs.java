/*
An 8th standard student has been assigned a task as part of punishment for his 
mistake.

The task is, there is an input string STR(without any space) and an array of 
strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
index and ending index of every string in words[] in the input string STR.

Note: Print the pairs[s, e] in sorted order.
(i.e., sort them by their first coordinate, and in case of ties sort them by 
their second coordinate).

Input Format
------------
Line-1: string STR(without any space)
Line-2: space separated strings, words[]

Output Format
-------------
Print the pairs[s, e] in sorted order.


Sample Input-1:
---------------
thekmecandngitcolleges
colleges kmec ngit

Sample Output-1:
----------------
3 6
10 13
14 21


Sample Input-2:
---------------
xyxyx
xyx xy

Sample Output-2:
----------------
0 1
0 2
2 3
2 4

Explanation: 
------------
Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


Sample Input-3:
---------------
kmecngitkmitarecsecolleges
kmit ngit kmec cse

Sample Output-3:
----------------
0 3
4 7
8 11
15 17

*/

import java.util.*;

class TrieNode
{
    TrieNode[] arr;
    boolean isEnd;   /*indicate whether there is a word*/
    public TrieNode()
	{
        isEnd=false;
        arr=new TrieNode[26];
    }
}
class IndexPairs
{
    public int[][] indexPairs(String text, String[] words) 
	{
        /*initializing tire and put all word from words into Trie.*/
        TrieNode root=new TrieNode();
        //create a trie
        for(String word:words)
        {
            TrieNode node=root;
            for(int i=0;i<word.length();i++)
            {
                char c=word.charAt(i);
                if(node.arr[c-'a']==null)
                {
                    TrieNode cur=new TrieNode();
                    node.arr[c-'a']=cur;
                }
                node=node.arr[c-'a'];
            }
            node.isEnd=true;
        }
        
        /*if text is "ababa", check "ababa","baba","aba","ba","a" individually.*/
        int len=text.length();
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<len;i++)
		{
            TrieNode cur=root;
            char cc=text.charAt(i);
            int j=i;   /*j is our moving index*/
            while(cur.arr[cc-'a']!=null)
            {
               cur=cur.arr[cc-'a'];
               if(cur.isEnd)
               {
                   list.add(new int[]{i,j});
               }
               j++;
               if(j==len) break;
               else cc=text.charAt(j);
            };
            //logic
        }
        /*put all the pairs from list into array*/
        int size=list.size();
        int[][] res=new int[size][2];
        //logic
        int i=0;
        for(int[] r:list)
        {
            res[i]=r;
            i++;
        }
        return res;
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String text=sc.nextLine();
		String dict[]=sc.nextLine().split(" ");
		int res[][]=new IndexPairs().indexPairs(text,dict);
		for(int[] ans: res)
		{
			System.out.println(ans[0]+" "+ans[1]);
		}
        sc.close();
	}
}