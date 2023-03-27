import java.util.*;

class BinaryTreeNode
{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data)
	{
		this.data = data; 
		left = null; 
		right = null; 
	}
}

public class LonelyNodesBFS
{
    public static List<Integer> getLonelyNodes(BinaryTreeNode root) 
    {
        Queue<BinaryTreeNode> q=new java.util.LinkedList<>();
        List<Integer> res=new ArrayList<>();
        //logic
        if(root==null) return res;
        q.offer(root);
        while(!q.isEmpty())
        {
            BinaryTreeNode node=q.poll();
            if(node.left!=null)
            {
                if(node.right==null)
                {
                    q.offer(node.left);
                    res.add(node.left.data);
                }
                else q.offer(node.left);
            }
            if(node.right!=null)
            {
                if(node.left==null)
                {
                    q.offer(node.right);
                    res.add(node.right.data);
                }
                else q.offer(node.right);
            }
        }
        return res;
    }
	public static void main(String args[])
	{
		BinaryTreeNode root = new BinaryTreeNode(7); 
		root.left = new BinaryTreeNode(1); 
		root.right = new BinaryTreeNode(4); 
		root.left.left = new BinaryTreeNode(6); 
		root.right.left = new BinaryTreeNode(5); 
		root.right.right=new BinaryTreeNode(3);
		root.right.right.right = new BinaryTreeNode(2); 
		System.out.println(getLonelyNodes(root));
	}
}
