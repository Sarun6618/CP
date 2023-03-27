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

class LonelyNodesDFS
{
    public static List<Integer> getLonelyNodes(BinaryTreeNode root) 
	{
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public static void dfs(BinaryTreeNode node, List<Integer> result) 
	{
        //logic
        if(node==null ||node.left==null&&node.right==null) return;
        if(node.left==null) result.add(node.right.data);
        if(node.right==null) result.add(node.left.data);
        dfs(node.left,result);
        dfs(node.right,result);
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
