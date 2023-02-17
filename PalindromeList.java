import java.util.*;
class node
{
		int data;
		node next;
};

class LList
{
	node head;
    //constructor
    LList()
    {
        head=null;
    }

	void create(int x)
	{
	    //logic
	    node nn,temp=head;
	    nn=new node();
	    nn.data=x;
	    nn.next=null;
	    if(head==null)
	    {
	        head=nn;
	        return;
	    }
	    while(temp.next!=null)
	    {
	        temp=temp.next;
	    }
	    temp.next=nn;
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

	node left;
 
    public boolean isPalindrome() 
	{
        left = head;
 
        boolean result = check(head);
        return result;
    }
 
    public boolean check(node right)
	{
 
        //stop recursion
        if(right==null)
        return true;
        else
        {
            boolean x=check(right.next);
            if(!x)
            return false;
            else
            {
                boolean y=(right.data==left.data);
                left=left.next;
                return y;
            }
        }
        
        //if sub-list is not palindrome,  return false
        
        //current left and right
        
        //move left to next
        
    }
}

class  PalindromeList
{
	public static void main(String[] args) 
	{
		LList l=new LList();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of values");
		int n=s.nextInt();
		System.out.println("Enter values");
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
