/*
In a school, the students are given an array of strings words[]. Students have 
to find the longest string in words[] such that every prefix of it is also in 
words.

For example, let words = ["a", "app", "ap","appl", "apply"]. The string "apply" 
has prefixes "ap","app","appl" and "a", all of which are in words.

Your task is the find and return the longest string in words as described above.

If there is more than one string with the same length, return the 
lexicographically smallest one, and if no string exists, return "".

Input Format
-------------
Line1: string separated by spaces
 
Output Format
--------------
string 

Sample Input-1:
---------------
k kmi km kmit

Sample Output-1:
----------------
kmit

Explanation:
------------
"kmit" has prefixes "kmi", "km", "k" and all of them appear in words.


Sample Input-2:
---------------
t tanker tup tupl tu tuple tupla

Sample Output-2:
----------------
tupla

Explanation:
------------
Both "tuple" and "tupla" have all their prefixes in words.
However, "tupla" is lexicographically smaller, so we return that.


Sample Input-3:
---------------
abc bc ab abcd

Sample Output-3:
----------------
""


*/

import java.util.*;

class TrieNode 
{
    TrieNode arr[] = new TrieNode[26];
    boolean isEnd;
}

class LongestWord 
{
    TrieNode root = new TrieNode();
    String res = "";
    public String longestWord(String[] words)
	{
        for (String word : words) addWord(word);
        for (String word : words) searchPrefix(word);
        return res;
    }
    
    private void searchPrefix(String word) 
	{
        //logic
        TrieNode cur=root;
		for(int i=0;i<word.length();i++)
		{
		    char ch=word.charAt(i);
		    cur=cur.arr[ch-'a'];
		    if(cur.isEnd==false) return;
		}
		if((res.length()<word.length())||(res.length()==word.length()&&res.compareTo(word)>0)) res=word;
    }
    
    private void addWord(String word) 
	{
		//logic
		TrieNode node=root;
		for(int i=0;i<word.length();i++)
		{
		    char ch=word.charAt(i);
		    if(node.arr[ch-'a']==null)
		    {
		        TrieNode cur=new TrieNode();
		        node.arr[ch-'a']=cur;
		    }
		    node=node.arr[ch-'a'];
		}
		node.isEnd=true;
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String dict[]=sc.nextLine().split(" ");
		System.out.println(new LongestWord().longestWord(dict));
		sc.close();
	}
}


	