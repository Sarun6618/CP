import java.util.*;

class Solution 
{
    class SegmentTreeNode 
	{
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) 
		{
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
      
    SegmentTreeNode root = null;
   
    public Solution(int[] nums) 
	{
        root = buildTree(nums, 0, nums.length-1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) 
	{
        if (start > end) 
		{
            return null;
        } 
		else 
		{
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) 
			{
                ret.sum = nums[start];
            } 
			else 
			{
                int mid = (start+end) / 2;             
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }         
            return ret;
        }
    }
   
    void update(int i, int val) 
	{
        update(root, i, val);
    }
   
    void update(SegmentTreeNode root, int pos, int val) 
	{
        if (root.start == root.end) 
		{
           root.sum = val;
        } 
		else 
		{
            int mid = (root.start + root.end) / 2;
            if (pos <= mid) 
			{
                 update(root.left, pos, val);
            } 
			else 
			{
                 update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) 
	{
        return sumRange(root, i, j);
    }
    
    public int sumRange(SegmentTreeNode root, int start, int end) 
	{
        if (root.end == end && root.start == start) 
		{
            return root.sum;
        } 
		else 
		{
            int mid = (root.start + root.end) / 2;
            if (end <= mid) 
			{
                return sumRange(root.left, start, end);
            } 
			else if (start >= mid+1) 
			{
                return sumRange(root.right, start, end);
            }  
			else 
			{    
                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
            }
        }
    }
}

class SegmentTreeLL
{	
	public static void main(String args[] ) 
	{
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int[] nums=new int[n];
		for(int i=0; i<n; i++)
		{
			 nums[i] = s.nextInt();
		}
		Solution na=new Solution(nums);
		System.out.println("Enter range");		
		int s1 = s.nextInt();
		int s2 = s.nextInt();
		System.out.println(na.sumRange(s1,s2));
		System.out.println("Enter index and value to be updated");
		int ind = s.nextInt();
		int val= s.nextInt();
		na.update(ind,val);
		System.out.println(na.sumRange(s1,s2));
        s.close();
	}
}