import java.util.*;
//create class node
class node
{
    int data;
    node next;
}
class LList
{
	//declare node reference
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
    public void removeNthFromEnd(int n) 
	{
        //logic
        if(head==null)
        return;
        node fp=head,sp=head;
        while(n!=0)
        {
            fp=fp.next;
            n--;
        }
        while(fp.next!=null)
        {
            fp=fp.next;
            sp=sp.next;
        }
        sp.next=sp.next.next;
    }
}

class  RemoveNthNode
{
	public static void main(String[] args) 
	{
		LList l=new LList();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of values");
		//read value
		int n=s.nextInt();
		System.out.println("Enter  values");
		//read values and store
		for(int i=0;i<n;i++)
		{
		    int x=s.nextInt();
		    l.create(x);
		}
		System.out.println("List is");
		l.display();
		System.out.println("Enter the number of the node to be deleted from last");
		//read 
		int m=s.nextInt();
		if(n<m||n<1)
		{
			System.out.println("Invalid Input");
			System.exit(0);
		}
		//call the function to remove node
		l.removeNthFromEnd(m);
		System.out.println("Updated List is");
		l.display();
        s.close();		
	}
}

