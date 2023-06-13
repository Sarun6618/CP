import java.util.*;
class node
{
		int data;
		node next;
}
class LList
{
// 	Stack<Integer> s=new Stack<>();
    node head=new node();
    
    LList(){
        head=null;
    }
		void create(int x){
	    node t=head,nn=new node();
	    nn.data=x;
	   // s.push(x);
	    nn.next=null;
	    if(head==null)
	    {
	        head=nn;
	        return;
	    }
	    while(t.next!=null)
	    {t=t.next;
	    }
	    t.next=nn;
		}

	void display()
	{
		node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}   
    boolean isPalindrome()
    {
        java.util.Stack<Integer>s=new java.util.Stack<>();
        node fp=head,sp=head;
        while(sp!=null)
		{
		    s.push(sp.data);
            sp=sp.next;
		}
		while(fp!=null)
        {
            if(fp.data!=s.pop())
            return false;
            fp=fp.next;
        }
        return true;
    }
}
	
class  PalindromeListNR
{
	public static void main(String[] args) 
	{
		LList l=new LList();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of values");
		int n=s.nextInt();
		System.out.println("Enter  values");
		for(int i=1;i<=n;i++)
		{
			int x=s.nextInt();
			l.create(x);
		}
		System.out.println("List is");
		l.display();

		System.out.println("Is Palindrome "+l.isPalindrome());
		s.close();
	}
}
