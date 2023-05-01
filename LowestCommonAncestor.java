import java.util.*;

class BinaryTreeNode{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class LowestCommonAncestor
{
	static int depth[],parent[];
	static boolean visited[];
	static BinaryTreeNode root;
	static BinaryTreeNode temp = root;
	static void insert(BinaryTreeNode temp, int key)
    {
        //logic
        if(temp==null)
        {
            root=new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q=new java.util.LinkedList<>();
        q.add(temp);
        while(!q.isEmpty())
        {
            temp=q.poll();
            if(temp.left==null)
            {
                temp.left=new BinaryTreeNode(key);
                break;
            }
            q.add(temp.left);
            if(temp.right==null)
            {
                temp.right=new BinaryTreeNode(key);
                break;
            }
            q.add(temp.right);
        }
	}

		public static void dfs(BinaryTreeNode root)
		{
			//logic
			visited[root.data]=true;
			if(root.left!=null)
			{
			    depth[root.left.data]=depth[root.data]+1;
			    parent[root.left.data]=root.data;
			    dfs(root.left);
			}
			if(root.right!=null)
			{
			    depth[root.right.data]=depth[root.data]+1;
			    parent[root.right.data]=root.data;
			    dfs(root.right);
			}
		}

		static BinaryTreeNode lca(BinaryTreeNode root,BinaryTreeNode u, BinaryTreeNode v)
		{
		    //logic
		    while(depth[u.data]!=depth[v.data])
		    {
		        if(depth[u.data]>depth[v.data])
		        {
		            depth[u.data]=depth[parent[u.data]];
		            u.data=parent[u.data];
		        }
		        else
		        {
		            depth[v.data]=depth[parent[v.data]];
		            v.data=parent[v.data];
		        }
		    }
		    while(u.data!=v.data)
		    {
		        u.data=parent[u.data];
		        v.data=parent[v.data];
		    }
		    return u;
		}
    	public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			String str[]=sc.nextLine().split(" ");
			root=new BinaryTreeNode(Integer.parseInt(str[0]));
			for(int i=1 ; i<str.length; i++)
				insert(root,Integer.parseInt(str[i]));
			BinaryTreeNode p=new BinaryTreeNode(sc.nextInt());
			BinaryTreeNode q=new BinaryTreeNode(sc.nextInt());
			depth=new int[100];
			parent=new int[100];
			visited=new boolean[100];
			depth[root.data]=1;
			dfs(root);
			BinaryTreeNode res=lca(root,p,q);
			System.out.println(res.data);
            sc.close();
		}
}