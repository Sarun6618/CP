import java.util.*;
class TreapNode
{
    int data;
    int priority;
    TreapNode left;
    TreapNode right;
    TreapNode(int data)
    {
        this.data = data;
        this.priority = new Random().nextInt(1000);
        this.left = this.right = null;
    }
}
class Treap
{
    public static TreapNode rotateLeft(TreapNode root)
    {
        TreapNode R=root.right;
        TreapNode X=root.right.left;
        R.left=root;
        root.right=X;
        return R;
        //logic
    }
    public static TreapNode rotateRight(TreapNode root)
    {
        TreapNode L=root.left;
        TreapNode Y=root.left.right;
        L.right=root;
        root.left=Y;
        return L;
        //logic
    }
    public static TreapNode insertNode(TreapNode root, int data)
	{
	    if(root==null)
	    {
	        return new TreapNode(data);
	    }
	    if(data<root.data)
	    {
	        root.left=insertNode(root.left,data);
	        if(root.left!=null && root.left.priority>root.priority)
	        root=rotateRight(root);
	    }
	    else
	    {
	        root.right=insertNode(root.right,data);
	        if(root.right!=null && root.right.priority>root.priority)
	         root=rotateLeft(root);
	    }
	    return root;
        //logic
	}
    static void inorder(TreapNode root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(""+root.data);
            inorder(root.right);
        }
        //logic
    }
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
		int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements");
		for(int i=0;i<n;i++)
		{
            arr[i] = sc.nextInt();
		}
        TreapNode root = null;
        for(int a:arr)
		{
            root = insertNode(root,a);
		}
        inorder(root);
        sc.close();
	}
}