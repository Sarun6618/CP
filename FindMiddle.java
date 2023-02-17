import java.util.*;
//create node
class node
{
    int data;
    node next;
}
class LList
{
	node head=new node();
	LList()
	{
	    head=null;
	}
	//constructor

	//create function
	void create(int x)
	{
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

	int returnMiddle()
	{
		//logic
		node fp=head,sp=head;
		while(sp.next!=null && sp.next.next!=null)
		{
		    fp=fp.next;
		    sp=sp.next.next;
		}
		return fp.data;
	}
}

class  FindMiddle
{
	public static void main(String[] args) 
	{
		// int ch;
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

		System.out.println("Middle Element is "+l.returnMiddle());
		s.close();
	}
}
