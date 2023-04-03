class STree
{
	// A utility function to get the middle index from corner indexes. 
	public static int getMid(int s, int e) 
	{
		//logic 
		return (s+e)/2;
	} 

	/* A recursive function to get the sum of values in the given range 
		of the array. The following are parameters for this function. 

		st --> array segment tree 
		si --> Index of current node in the segment tree. Initially 
				0 is passed as root is always at index 0 
		sl & sr --> Starting and ending indexes of the segment represented 
					by current node, i.e., st[si] 
		l & r --> Starting and ending indexes of query range */
	public static int getSumUtil(int[] st, int si, int sl, int sr, int l, int r) 
	{ 
		// If segment of this node is a part of given range, then return 
		// the sum of the segment 
		
		//logic
		if(l<=sl && r>=sr) return st[si];

		// If segment of this node is outside the given range 
		
		//logic
		if(sr<l||sl>r) return 0;

		// If a part of this segment overlaps with the given range 
		//logic
		int mid=getMid(sl,sr);
		return getSumUtil(st,2*si+1,sl,mid,l,r)+getSumUtil(st,2*si+2,mid+1,sr,l,r);
	} 

	/* A recursive function to update the nodes which have the given 
	index in their range. The following are parameters 
		st, si, sl and sr are same as getSumUtil() 
		pos --> index of the element to be updated. This index is 
				in the input array. 
	diff --> Value to be added to all nodes which have i in range */
	public static void updateValueUtil(int[] st, int si, int sl, int sr, int pos, int diff) 
	{ 
		// Base Case: If the input index lies outside the range of 
		// this segment 
	    //logic
	    if(sl>pos||sr<pos) return;

		// If the input index is in range of this node, then update 
		// the value of the node and its children 
		//logic 
		st[si]=st[si]+diff;
		if(sl!=sr)
		{
		    int mid=getMid(sl,sr);
		    updateValueUtil(st,2*si+1,sl,mid,pos,diff);
		    updateValueUtil(st,2*si+2,mid+1,sr,pos,diff);
		}
	} 

	// The function to update a value in input array and segment tree. 
	// It uses updateValueUtil() to update the value in segment tree 
	public static void updateValue(int[] a, int[] st, int n, int i, int new_val) 
	{ 
		// Check for erroneous input index 
		//logic
		if(i<0||i>n-1)
		{
		    System.out.println("Invalid Input");
		    return;
		}

		// Get the difference between new value and old value 
		//logic 
		int diff=new_val-a[i];

		// Update the value in array 
	    //logic
	    a[i]=new_val;

		// Update the values of nodes in segment tree 
	    //logic
	    updateValueUtil(st,0,0,n-1,i,diff);
	} 

	// Return sum of elements in range from index l (quey start) 
	// to r (query end). It mainly uses getSumUtil() 
	public static int getSum(int[] st, int n, int l, int r) 
	{ 
		// Check for erroneous input values 
		//logic
		if(l<0||r>n-1||l>r)
		{
		    System.out.println("Invalid Input");
		    return -1;
		}
		return getSumUtil(st,0,0,n-1,l,r);
	}

	// A recursive function that constructs Segment Tree for array[ss..se]. 
	// si is index of current node in segment tree st 
	public static int constructSTUtil(int[] st, int si, int[] a,  int l, int r  ) 
	{ 
		// If there is one element in array, store it in current node of 
		// segment tree and return 
		//logic
		if(l==r)
		{
		    st[si]=a[l];
		    return a[l];
		}

		// If there are more than one elements, then recur for left and 
		// right subtrees and store the sum of values in this node 
		//logic
		int mid=getMid(l,r);
		st[si]=constructSTUtil(st,2*si+1,a,l,mid)+constructSTUtil(st,2*si+2,a,mid+1,r);
		return st[si];
	} 

	/* Function to construct segment tree from given array. This function 
	allocates memory for segment tree and calls constructSTUtil() to 
	fill the allocated memory */
	public static int[] constructST(int[] a, int n) 
	{ 
		// Allocate memory for the segment tree 

		//Height of segment tree 
		int x = (int)(Math.ceil(Math.log(n) / Math.log(2))); 

		//Maximum size of segment tree 
		int max_size = 2*(int)Math.pow(2, x) - 1; 

		// Allocate memory 
		int[] st = new int[max_size]; 

		// Fill the allocated memory st 
		constructSTUtil(st, 0, a, 0, n-1); 

		// Return the constructed segment tree 
		return st; 
	}

	public static void main(String[] args) 
	{ 
		int a[] = {1, 3, 5, 7, 9, 11}; 
		int n = a.length; 

		// Build segment tree from given array 
		int[] st = constructST(a, n); 

		// Print sum of values in array from index 1 to 3 
		System.out.println("Sum of values in given range = "+ getSum(st, n, 1, 3)); 

			// Update: set arr[1] = 10 and update corresponding 
			// segment tree nodes 
			updateValue(a, st, n, 1, 10); 

			// Find sum after the value is updated 
			System.out.println("Updated sum of values in given range = "+ getSum(st, n, 1, 3)); 
	} 
}