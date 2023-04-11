import java.util.*;
class Trie 
{
    class TrieNode
	{
        boolean isEnd;
        TrieNode arr[];
		TrieNode()
		{
			arr=new TrieNode[26];
			isEnd=false;
		}
    }
    TrieNode root;
    public Trie() 
	{
        root = new TrieNode();
    }
    
    public void insert(String word) 
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
    
    public boolean search(String word) 
	{
        //logic
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(node.arr[ch-'a']==null) return false;
            node=node.arr[ch-'a'];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) 
	{ 
        //logic
        TrieNode node=root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch=prefix.charAt(i);
            if(node.arr[ch-'a']==null) return false;
            node=node.arr[ch-'a'];
        }
        return true;
    }
}
class  TrieDemo
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		String str[]=new String[10];
		Trie t=new Trie();
		for(int i=0;i<10;i++)
		{
			str[i]=s.next();
			t.insert(str[i]);
		}
		System.out.println("Enter string to search");
		String s1=s.next();
		System.out.println(t.search(s1));
		System.out.println("Enter prefix");
		String s2=s.next();
		System.out.println(t.startsWith(s2));
        s.close();
	}
}
